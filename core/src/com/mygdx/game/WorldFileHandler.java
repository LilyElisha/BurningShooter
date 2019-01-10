package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class WorldFileHandler {
    public static void readWorldFile (String worldLocation) {

        FileHandle file = Gdx.files.internal(worldLocation);
        String st = "";
        try {
            st = file.readString();
            System.out.println(st);
        } catch (Exception e) {
            System.out.println("No world found");
        }

        WorldSetup.WorldTexture = st;
    }
}
