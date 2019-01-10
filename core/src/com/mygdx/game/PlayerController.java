package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class PlayerController {

    public static void keyInput() {
        if (Gdx.input.isKeyPressed(Keys.A)) {
            main.playerX++;
            main.backgroundSpriteX++;
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            main.playerX--;
            main.backgroundSpriteX--;
        }
    }

    public void Controller() {

        main.player = new Sprite(main.texture);
        main.playerX = (main.canvisWidth * 0);
        main.playerY = main.canvisHeight; //can be 0
    }
}