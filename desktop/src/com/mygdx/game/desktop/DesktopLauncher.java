package com.mygdx.game.desktop;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.main;

public class DesktopLauncher {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static double width = screenSize.getWidth();
	static double height = screenSize.getHeight();
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "burning Shooter";
        config.width = (int) width;
        config.height = (int) height;
        //config.height = canvisHeight;
        //config.foregroundFPS = (60);
        //config.backgroundFPS = (60);
        new LwjglApplication(new main(), config);
    }
}