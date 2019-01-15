package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Sprites.*;

public class PlayScreen implements Screen {
    Array<Body> activeBody;
    Array<Body> destroyBody;
    Array<Body> destroyBodyed;
    private main game;
    private TextureAtlas atlas;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Player player;
    private InversePlayer inversePlayer;
    private Bullet bullet;

    public PlayScreen(main game) {
        atlas = new TextureAtlas("BurningShooterPlayer.pack");
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(main.V_WIDTH / main.PPM, main.V_HEIGHT / main.PPM, gamecam);
        hud = new Hud(game.batch);

        maploader = new TmxMapLoader();
        map = maploader.load("map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / main.PPM);
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);

        world = new World(new Vector2(0, -10), true);

        world.setContactListener(
                new ContactListener() {
                    @Override
                    public void beginContact(Contact contact) {
                        Fixture fA = contact.getFixtureA();
                        Fixture fB = contact.getFixtureB();
                        String fAString = null;
                        String fBString = null;
                        if (Bullet.b2body.getFixtureList().contains(fA, false))
                            fAString = "Bullet";
                        if (Bullet.b2body.getFixtureList().contains(fB, false))
                            fBString = "Bullet";
                        if (InversePlayer.b2body.getFixtureList().contains(fA, false))
                            fAString = "InversePlayer";
                        if (InversePlayer.b2body.getFixtureList().contains(fB, false))
                            fBString = "InversePlayer";
                        if (fAString != null && fBString != null)
                            Gdx.app.log("beginContact", "between " + fAString + " and " + fBString);
                    }

                    @Override
                    public void endContact(Contact contact) {
                    }

                    @Override
                    public void preSolve(Contact contact, Manifold oldManifold) {
                        //if contact between inverse player and bullet
                        if ((InversePlayer.b2body.getFixtureList().contains(contact.getFixtureB(), false) && (Bullet.b2body.getFixtureList().contains(contact.getFixtureA(), false))) || (InversePlayer.b2body.getFixtureList().contains(contact.getFixtureA(), false) && (Bullet.b2body.getFixtureList().contains(contact.getFixtureB(), false)))) {
                            if (contact.getFixtureA().getBody() instanceof Body
                                    && contact.getFixtureB().getBody() instanceof Body) {
                                destroy(contact.getFixtureA().getBody());
                                destroy(contact.getFixtureB().getBody());
                            }
                        } else {
                            if (projectile.b2body.getFixtureList().contains(contact.getFixtureB(), false) && !player.b2body.getFixtureList().contains(contact.getFixtureA(), false)) {
                                destroy(contact.getFixtureB().getBody());
                            }
                            if (projectile.b2body.getFixtureList().contains(contact.getFixtureA(), false) && !player.b2body.getFixtureList().contains(contact.getFixtureB(), false)) {
                                destroy(contact.getFixtureA().getBody());
                            }
                        }
                    }

                    @Override
                    public void postSolve(Contact contact, ContactImpulse impulse) {

                    }
                });

        activeBody = new Array<Body>();
        destroyBody = new Array<Body>();
        destroyBodyed = new Array<Body>();

        b2dr = new Box2DDebugRenderer();

        new B2WorldCreator(this);

        player = new Player(this);

        inversePlayer = new InversePlayer(this, .32f, .32f);

        bullet = new Bullet(this, .64f, .64f);

        destroy(projectile.b2body);

    }

    public TextureAtlas getAtlas() {
        return atlas;
    }

    @Override
    public void show() {
    }

    public void handleInput(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.W))
            player.b2body.applyLinearImpulse(new Vector2(0, 4f), player.b2body.getWorldCenter(), true);
        if (Gdx.input.isKeyPressed(Input.Keys.D) && player.b2body.getLinearVelocity().x <= 2)
            player.b2body.applyLinearImpulse(new Vector2(0.1f, 0), player.b2body.getWorldCenter(), true);
        if (Gdx.input.isKeyPressed(Input.Keys.A) && player.b2body.getLinearVelocity().x >= -2)
            player.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2body.getWorldCenter(), true);
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (destroyBodyed.contains(projectile.b2body, false)) {
                Bullet.defineBullet();
                destroyBodyed.removeValue(projectile.b2body, false);
            }
            projectile.b2body.setLinearVelocity(0, 0);
            projectile.b2body.setTransform(new Vector2((player.b2body.getPosition().x + player.getWidth() - (3 / main.PPM)), (player.b2body.getPosition().y)), 0);
            projectile.b2body.applyLinearImpulse(new Vector2(Bullet.BULLET_SPEED, 0), projectile.b2body.getWorldCenter(), true);
            Bullet.Right = true;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            if (destroyBodyed.contains(projectile.b2body, false)) {
                Bullet.defineBullet();
                destroyBodyed.removeValue(projectile.b2body, false);
            }
            projectile.b2body.setLinearVelocity(0, 0);
            projectile.b2body.setTransform(new Vector2((player.b2body.getPosition().x - player.getWidth() + (3 / main.PPM)), (player.b2body.getPosition().y)), 0);
            projectile.b2body.applyLinearImpulse(new Vector2(-Bullet.BULLET_SPEED, 0), projectile.b2body.getWorldCenter(), true);
            Bullet.Right = false;
        }
    }

    public void update(float dt) {

        world.step(1 / 60f, 6, 2);

        for (Body body : destroyBody) {
            world.destroyBody(body);
        }
        destroyBody.clear();

        handleInput(dt);
        player.update(dt);
        inversePlayer.update(dt);
        bullet.update(dt);

        gamecam.position.x = player.b2body.getPosition().x;

        gamecam.update();
        renderer.setView(gamecam);
    }

    public void destroy(Body object) {
        if (!destroyBody.contains(object, false)) {
            destroyBody.add(object);
            destroyBodyed.add(object);
            activeBody.removeValue(object, true);
        }
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world, gamecam.combined);

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player.draw(game.batch);
        if (!destroyBodyed.contains(Enemy.b2body, false))
            inversePlayer.draw(game.batch);
        if (!destroyBodyed.contains(projectile.b2body, false)) {
            bullet.draw(game.batch);
        }
        game.batch.end();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, width);
    }

    public TiledMap getMap() {
        return map;
    }

    public World getWorld() {
        return world;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        world.dispose();
        b2dr.dispose();
        hud.dispose();
    }

}
