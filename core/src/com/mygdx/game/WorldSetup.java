package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.io.File;
import java.util.ArrayList;

public class WorldSetup {

    public static String WorldTexture = "";
    public static Texture backgroundTexture; //can be package private
    public static Texture backgroundTexture2;
    public static Texture backgroundTexture3;
    public static ArrayList world_1x1;

    public void start() {
        File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt");
        String file_string = file.toString();
        System.out.println(file_string);
        WorldSetup.WorldTexture = "sunny ground.png";
        backgroundTexture = new Texture(Gdx.files.internal(WorldTexture));
        backgroundTexture2 = new Texture(Gdx.files.internal(WorldTexture));
        backgroundTexture3 = new Texture(Gdx.files.internal(WorldTexture));

    }

}
