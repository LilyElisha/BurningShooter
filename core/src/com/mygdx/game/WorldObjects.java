package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

@SuppressWarnings("unused")
public class WorldObjects {
	public static ShapeRenderer shapeRender = new ShapeRenderer();
	public static void Square( int x, int y, int width, int height) {
		
        shapeRender.setProjectionMatrix(main.batch.getProjectionMatrix());
        shapeRender.begin(ShapeType.Filled);
        shapeRender.rect(x+main.playerX, y, width, height);
        shapeRender.end();
	}
}