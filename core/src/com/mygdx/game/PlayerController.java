package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class PlayerController {
    static int speed = 1;
    public static int jump = 1;
    private static boolean jumps = true;

    static void keyInput() {
        if (Gdx.input.isKeyPressed(Keys.A)) {
            main.playerX += speed;
            main.backgroundSpriteX += speed;
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            main.playerX -= speed;
            main.backgroundSpriteX -= speed;
        }
        if (Gdx.input.isKeyPressed(Keys.W) && jumps) {
            jumps = false;
            for (int i = 5; i > 0; i--) {
                main.playerY += i;
            }
            System.out.print("l");
            for (int l = 5; l > 0; l--) {
                main.playerY -= l;
            }
            jumps = true;
        }
    }

    void Controller() {

        main.player = new Sprite(main.texture);
        main.playerX = (main.canvisWidth * 0);
        main.playerY = (main.canvisHeight * 0); //can be 0
    }
}