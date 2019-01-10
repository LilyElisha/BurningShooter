package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import worlds.World_1x1;


//import worlds.World_1x1;
@SuppressWarnings("unused")
public class main implements ApplicationListener {
    public static int canvisWidth = 800;
    public static int canvisHeight = 480;
    static SpriteBatch batch;
    private double playerSize = .4; //can be local variable.
    public static Sprite backgroundSprite;
    public static int backgroundSpriteX = 0;
    public static final int backgroundSpriteY = 0;
    public static Texture texture;
    public static Sprite backgroundSprite2;
    public static int backgroundSprite2X = -canvisWidth;
    public static final int backgroundSprite2Y = 0;
    public static Sprite player;
    public static int playerX;
    public static int playerY;

    public void create() {
        WorldObjects.shapeRender.setAutoShapeType(true);
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("imageedit_3_3813241913.png"));
        PlayerController class2 = new PlayerController();
        class2.Controller();
        WorldSetup class3 = new WorldSetup();
        class3.start();
        player.setSize((float) (player.getWidth() * playerSize), (float) (player.getHeight() * playerSize));
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        PlayerController.keyInput();
        WorldController.Scroll();
        batch.begin();
        batch.draw(WorldSetup.backgroundTexture, backgroundSpriteX, backgroundSpriteY);
        batch.draw(WorldSetup.backgroundTexture2, backgroundSprite2X, backgroundSprite2Y);
        batch.draw(texture, playerX, playerY, player.getWidth(), player.getHeight());
        batch.end();
        WorldSetup.WorldRender();
    }


    public void resize(int width, int height) {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
    }

}
