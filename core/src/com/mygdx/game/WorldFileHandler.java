package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;



public class WorldFileHandler {
    static String texture;

    static void readFile(String fileLocation) {

        FileHandle file = Gdx.files.internal(fileLocation);
        String st = "";
        try {
            st = file.readString();
            System.out.println(st);
        } catch (Exception e) {
            System.out.println("No file found");
        }

        texture = st;
    }

    static void readMultiLineFIle(String fileLocation) {
        FileHandle handle = Gdx.files.internal(fileLocation);
        String text = handle.readString();
        String wordsArray[] = text.split("\\r?\\n");
        for(String word : wordsArray) {
            System.out.println(word);
        }
    }
}
