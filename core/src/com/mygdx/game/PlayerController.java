package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class PlayerController {
    static int speed = 1;
    public static int jump = 20;
    
    static void keyInput() {
        if (Gdx.input.isKeyPressed(Keys.A)) {
            main.playerX += speed;
            main.backgroundSpriteX += speed;
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            main.playerX -= speed;
            main.backgroundSpriteX -= speed;
        }
        if (Gdx.input.isKeyPressed(Keys.W) && main.playerY == 0) {
        	for(main.Jumpframes = 0; main.Jumpframes < jump*100000; main.Jumpframes++) {
        		//Gdx.graphics.setContinuousRendering(false);
        		if(main.Jumpframes%100000 == 0) {
        			main.playerY++;
        		}
        	}
        	//Gdx.graphics.setContinuousRendering(true);
        }
    }

    static void Controller() {

        main.player = new Sprite(main.texture);
        main.playerX = (main.canvisWidth * 0);
        main.playerY = (main.canvisHeight * 0); //can be 0
    }
}