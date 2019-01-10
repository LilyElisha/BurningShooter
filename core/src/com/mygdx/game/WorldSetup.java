package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class WorldSetup {
    public static Texture backgroundTexture; //can be package private
    public static Texture backgroundTexture2;
//    World_1x1 W1x1 = new World_1x1();

    public static void WorldRender() {
//        World_1x1 W1x1 = new World_1x1();
//        W1x1.objs();
        WorldObjects.Square(200, 200, 200, 200);
    }

    public void start() {
        WorldFileHandler.readWorldFile("worlds/World_1x1.world");
        backgroundTexture = new Texture(Gdx.files.internal(WorldFileHandler.texture));
        backgroundTexture2 = new Texture(Gdx.files.internal(WorldFileHandler.texture));
    }
}
