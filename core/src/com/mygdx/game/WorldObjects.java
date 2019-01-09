package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

@SuppressWarnings("unused")
public class WorldObjects {
	
	public static ShapeRenderer shapeRender = new ShapeRenderer();
	
	public static void Square( int x, int y, int width, int height) {
		shapeRender.begin();
		shapeRender.rect(x, y, width, height);
		shapeRender.end();
	}
	
}
