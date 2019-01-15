package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.PlayScreen;
import com.mygdx.game.main;

public class InversePlayer extends Enemy {
    private float stateTime;
    private Animation<TextureRegion> walkAnimation;
    private Array<TextureRegion> frames;

    public InversePlayer(PlayScreen screen, float x, float y) {
        super(screen, x, y);
        frames = new Array<TextureRegion>();
        for (int i = 0; i < 4; i++)
            frames.add(new TextureRegion(screen.getAtlas().findRegion("BurningShooterPlayer"), i * 14 + 55, 0, 14, 33));
        walkAnimation = new Animation<TextureRegion>(0.1f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 14 / main.PPM, 33 / main.PPM);
    }

    public void update(float dt) {
        stateTime += dt;
        setPosition((b2body.getPosition().x - getWidth() / 2), (float) ((b2body.getPosition().y - getHeight() / 2) - .011));
        setRegion(walkAnimation.getKeyFrame(stateTime, false));
    }

    @Override
    protected void defineEnemy() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / main.PPM, 32 / main.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(14 / 2 / main.PPM, 33 / 2 / main.PPM);
        fdef.filter.categoryBits = main.ENEMY_BIT;
        // fdef.filter.maskBits = main.GROUND_BIT | main.ENEMY_BIT | main.PROJECTILE_BIT;

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }

}
