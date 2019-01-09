package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.main;

public class DesktopLauncher {
	public static int canvisWidth = 800;
	public static int canvisHeight = 480;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "game";
		config.width = canvisWidth;
		config.height = canvisHeight;
		new LwjglApplication(new main(), config);
	}
}