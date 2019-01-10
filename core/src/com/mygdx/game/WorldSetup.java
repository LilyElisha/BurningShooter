package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class WorldSetup {
    static Texture backgroundTexture;
    static Texture backgroundTexture2;

    static void WorldRender() {
        WorldObjects.Square(200, 200, 200, 200);
    }

    void start() {
        world_1x1();
    }

    private void world_1x1() {
        WorldFileHandler.readFile("worlds/World_1x1.world");
        WorldFileHandler.readMultiLineFIle("worlds/test.world");
        backgroundTexture = new Texture(Gdx.files.internal(WorldFileHandler.texture));
        backgroundTexture2 = new Texture(Gdx.files.internal(WorldFileHandler.texture));
    }
}
