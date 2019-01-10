package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class WorldSetup {
    static Texture backgroundTexture; //can be package private
    static Texture backgroundTexture2;
//    World_1x1 W1x1 = new World_1x1();

    static void WorldRender() {
//        World_1x1 W1x1 = new World_1x1();
//        W1x1.objs();
        WorldObjects.Square(200, 200, 200, 200);
    }

    void start() {
        world_1x1();
    }

    private void world_1x1() {
        WorldFileHandler.readWorldFile("worlds/World_1x1.world");
        backgroundTexture = new Texture(Gdx.files.internal(WorldFileHandler.texture));
        backgroundTexture2 = new Texture(Gdx.files.internal(WorldFileHandler.texture));
    }
}
