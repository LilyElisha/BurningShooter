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

import worlds.World_1x1;

@SuppressWarnings("unused")
public class WorldSetup {
    World_1x1 W1x1 = new World_1x1();
    public static String WorldTexture = "";
    public static Texture backgroundTexture; //can be package private
    public static Texture backgroundTexture2;

    public void start() {
        W1x1.go();
        backgroundTexture = new Texture(Gdx.files.internal(WorldTexture));
        backgroundTexture2 = new Texture(Gdx.files.internal(WorldTexture));
    }
    public static void WorldRender() {
        World_1x1 W1x1 = new World_1x1();
        W1x1.objs();
    }
}
