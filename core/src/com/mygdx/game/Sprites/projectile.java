package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.PlayScreen;

public abstract class projectile extends Sprite{
	protected static World world;
	protected PlayScreen screen;
	public static Body b2body;
	public projectile(PlayScreen screen, float x, float y) {
		projectile.world = screen.getWorld();
		this.screen = screen;
		setPosition(x, y);
		Bullet.defineBullet();
	}
}
