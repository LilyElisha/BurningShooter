package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;


public class WorldObjects {
    static ShapeRenderer shapeRender = new ShapeRenderer();

    static void Square(int x, int y, int width, int height) {

        shapeRender.setProjectionMatrix(main.batch.getProjectionMatrix());
        shapeRender.begin(ShapeType.Filled);
        shapeRender.rect(x + main.playerX, y, width, height);
        shapeRender.end();
    }
    public static void enemy () {
        //TODO actually make this work.

    }
}