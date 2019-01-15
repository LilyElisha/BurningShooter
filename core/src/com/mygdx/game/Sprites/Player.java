package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.PlayScreen;
import com.mygdx.game.main;

public class Player extends Sprite {
    public static World world;

    public State currentState;
    public State previosState;
    public Body b2body;
    private TextureRegion playerStand;
    private Animation<TextureRegion> playerRun;
    private Animation<TextureRegion> playerJump;
    private float stateTimer;
    private boolean runningRight = true;

    public Player(PlayScreen screen) {
        super(screen.getAtlas().findRegion("BurningShooterPlayer"));
        Player.world = screen.getWorld();
        currentState = State.STANDING;
        previosState = State.STANDING;
        stateTimer = 0;
        runningRight = true;

        Array<TextureRegion> frames = new Array<TextureRegion>();

        //run
        for (int i = 0; i < 4; i++)
            frames.add(new TextureRegion(getTexture(), i * 14, 0, 14, 33));
        playerRun = new Animation<TextureRegion>(0.08f, frames);
        frames.clear();

        //jump
        for (int i = 0; i < 2; i++)
            frames.add(new TextureRegion(getTexture(), i * 14, 0, 14, 33));
        playerJump = new Animation<TextureRegion>(0.1f, frames);
        playerStand = new TextureRegion(getTexture(), 0, 0, 14, 33);
        definePlayer();
        setBounds(getX(), getY(), 14 / main.PPM, 33 / main.PPM);
        setRegion(playerStand);
        frames.clear();
    }

    public void update(float dt) {
        setPosition((b2body.getPosition().x - getWidth() / 2), (float) ((b2body.getPosition().y - getHeight() / 2) - .011));
        setRegion(getFrame(dt));
    }

    public TextureRegion getFrame(float dt) {
        currentState = getState();

        TextureRegion region;
        switch (currentState) {
            case JUMPING:
                region = playerJump.getKeyFrame(stateTimer);
                break;
            case RUNNING:
                region = playerRun.getKeyFrame(stateTimer, true);
                break;
            case FALLING:
            case STANDING:
            default:
                region = playerStand;
                break;
        }

        if ((b2body.getLinearVelocity().x < 0 || !runningRight) && !region.isFlipX()) {
            region.flip(true, false);
            runningRight = false;
        } else if ((b2body.getLinearVelocity().x > 0 || runningRight) && region.isFlipX()) {
            region.flip(true, false);
            runningRight = true;
        }

        stateTimer = currentState == previosState ? stateTimer + dt : 0;
        previosState = currentState;
        return region;
    }

    public State getState() {
        if (b2body.getLinearVelocity().y > 0 || (b2body.getLinearVelocity().y < 0 && previosState == State.JUMPING))
            return State.JUMPING;
        else if (b2body.getLinearVelocity().y < 0)
            return State.FALLING;
        else if (b2body.getLinearVelocity().x != 0)
            return State.RUNNING;
        else
            return State.STANDING;

    }

    public void definePlayer() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / main.PPM, 32 / main.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();

        //CircleShape shape = new CircleShape();
        //shape.setRadius(6 / main.PPM);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(14 / 2 / main.PPM, 33 / 2 / main.PPM);
        fdef.filter.categoryBits = main.PLAYER_BIT;
        //fdef.filter.maskBits = main.GROUND_BIT | main.ENEMY_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef);

        //EdgeShape head = new EdgeShape();
    }

    public enum State {FALLING, JUMPING, STANDING, RUNNING}
}
