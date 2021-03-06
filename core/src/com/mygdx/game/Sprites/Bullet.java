package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.PlayScreen;
import com.mygdx.game.main;

public class Bullet extends projectile {
    public static float BULLET_SPEED = 10f;
    public static boolean Right = true;
    public static String bulletname;
    public static BodyDef bulletBdef = new BodyDef();
    private float stateTime;
    private Animation<TextureRegion> walkAnimation;
    private Array<TextureRegion> frames;

    public Bullet(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new Array<TextureRegion>();
        frames.add(new TextureRegion(screen.getAtlas().findRegion("BurningShooterPlayer"), 111, -1, 15, 8));
        walkAnimation = new Animation<TextureRegion>(0.1f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), (float) (7.5 / main.PPM), 4 / main.PPM);
    }

    public static void defineBullet() {
        bulletBdef.position.set(64 / main.PPM, 64 / main.PPM);
        bulletBdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bulletBdef);

        FixtureDef fdef = new FixtureDef();

        PolygonShape shape = new PolygonShape();
        shape.setAsBox((float) (7.5 / 2 / main.PPM), 4 / 2 / main.PPM);
        fdef.filter.categoryBits = main.PROJECTILE_BIT;
        fdef.shape = shape;
        fdef.density = 100;
        b2body.setBullet(true);
        b2body.createFixture(fdef);
        b2body.setUserData(b2body);
    }

    public void update(float dt) {
        stateTime += dt;
        setPosition((b2body.getPosition().x - getWidth() / 2), b2body.getPosition().y - getHeight() / 2);
        setRegion(walkAnimation.getKeyFrame(stateTime, true));

        if ((!Right) && !walkAnimation.getKeyFrame(dt).isFlipX()) {
            walkAnimation.getKeyFrame(dt).flip(true, false);
        } else if ((Right) && walkAnimation.getKeyFrame(dt).isFlipX()) {
            walkAnimation.getKeyFrame(dt).flip(true, false);
        }

    }
}
