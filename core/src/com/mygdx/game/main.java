package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class main implements ApplicationListener {
    public static final int backgroundSpriteY = 0;
    public static final int backgroundSprite2Y = 0;
    public static int canvisWidth = 800;
    public static int canvisHeight = 480;
    public static int backgroundSpriteX = 0;
    public static Texture texture;
    public static int backgroundSprite2X = -canvisWidth;
    public static Sprite player;
    public static int playerX;
    public static int playerY;
    static SpriteBatch spriteBatch;
    static int Jumpframes = 0;
    private double playerSize = .4;

    public void create() {
        WorldObjects.shapeRender.setAutoShapeType(true);
        spriteBatch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("imageedit_3_3813241913.png"));
        PlayerController.Controller();
        WorldSetup.start();
        player.setSize((float) (player.getWidth() * playerSize), (float) (player.getHeight() * playerSize));
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        PlayerController.keyInput();
        WorldController.Scroll();
        spriteBatch.begin();
        spriteBatch.draw(WorldSetup.backgroundTexture, backgroundSpriteX, backgroundSpriteY);
        spriteBatch.draw(WorldSetup.backgroundTexture2, backgroundSprite2X, backgroundSprite2Y);
        spriteBatch.draw(texture, playerX, playerY, player.getWidth(), player.getHeight());
        spriteBatch.end();
        WorldSetup.WorldRender();
        //Jumpframes++;
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
