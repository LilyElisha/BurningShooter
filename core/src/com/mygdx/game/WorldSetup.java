package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import worlds.World_1x1;


public class WorldSetup {
    public static String WorldTexture = "";
    public static Texture backgroundTexture; //can be package private
    public static Texture backgroundTexture2;
    World_1x1 W1x1 = new World_1x1();

    public static void WorldRender() {
        World_1x1 W1x1 = new World_1x1();
        W1x1.objs();
    }

    public void start() {
        W1x1.go();
        backgroundTexture = new Texture(Gdx.files.internal(WorldTexture));
        backgroundTexture2 = new Texture(Gdx.files.internal(WorldTexture));
    }
}
