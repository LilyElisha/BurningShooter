package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Player extends Sprite {
	public World world;
	public Body b2body;
	
	public Player(World world) {
		this.world = world;
		definePlayer();
	}
	public void definePlayer() {
		BodyDef bdef = new BodyDef();
		bdef.position.set(32 / main.PPM, 32 / main.PPM);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2body = world.createBody(bdef);
		
		FixtureDef fdef = new FixtureDef();
		CircleShape shape = new CircleShape();
		shape.setRadius(5 / main.PPM);
		
		fdef.shape = shape;
		b2body.createFixture(fdef);
	}
}
