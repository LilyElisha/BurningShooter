package com.mygdx.game.Sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.PlayScreen;

public abstract class projectile extends Sprite{
	protected World world;
	protected PlayScreen screen;
	public Body b2body;
	public projectile(PlayScreen screen, float x, float y) {
		this.world = screen.getWorld();
		this.screen = screen;
		setPosition(x, y);
		defineProjectile();
	}
	protected abstract void defineProjectile();
}
