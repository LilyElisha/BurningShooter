package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class WorldObjects {
	
	public static void Square(TextureRegion texture, int x, int y, int width, int height) {
		main.batch.draw(texture, x, y, 0, 0, width, height, 1, 1, 0);
	}
	
}
