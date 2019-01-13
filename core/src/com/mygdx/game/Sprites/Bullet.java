package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mygdx.game.main;

public class Bullet extends Sprite{
	Body b2body;
	protected void defineBullet() {
		BodyDef bdef = new BodyDef();
		bdef.position.set(com.mygdx.game.Sprites.Player.b2body.getPosition().x, 32 / main.PPM);
		bdef.type = BodyDef.BodyType.DynamicBody;
		b2body = Player.world.createBody(bdef);
		
		FixtureDef fdef = new FixtureDef();
		
	    PolygonShape shape = new PolygonShape();
	    shape.setAsBox(5 / 2 / main.PPM, 5 / 2 / main.PPM);
	    fdef.filter.categoryBits = main.ENEMY_BIT;
	    fdef.filter.maskBits = main.GROUND_BIT |
	    		main.ENEMY_BIT |
	    		main.OBJECT_BIT;
		
		fdef.shape = shape;
		b2body.createFixture(fdef);
	}

}
