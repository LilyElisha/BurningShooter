package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class PlayerController {
    static int speed = 1;
    public static int jump = 0;
    private static int test = 0;
    
    static void keyInput() {
    	jump++;
        if (Gdx.input.isKeyPressed(Keys.A)) {
            main.playerX += speed;
            main.backgroundSpriteX += speed;
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            main.playerX -= speed;
            main.backgroundSpriteX -= speed;
        }
        if (Gdx.input.isKeyPressed(Keys.W) && test == 0) {
        		if (jump<50 || test == 0) {
        			main.playerY++;
        		} else {
        			test++;
        		}
        }
        if (main.playerY>=50) {
        	test = 0;
        	jump = 0;
        }
    }

    static void Controller() {

        main.player = new Sprite(main.texture);
        main.playerX = (main.canvisWidth * 0);
        main.playerY = (main.canvisHeight * 0); //can be 0
    }
}