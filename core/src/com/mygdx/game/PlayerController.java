package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerController {
    public static void keyInput() {
        if (Gdx.input.isKeyPressed(Keys.D)) {
            main.playerX++;
            main.backgroundSpriteX++;
        }
        //&& main.playerX < main.canvisWidth-main.player.getWidth()
        if (Gdx.input.isKeyPressed(Keys.A)) {
            main.playerX--;
            main.backgroundSpriteX--;
        }
        //&& main.playerX > 0
    }

    /*
    main ct = new main();
    private static Sprite player = ct.player;
    private static*/
    public void Controller() {

        main.player = new Sprite(main.texture);
        main.playerX = (main.canvisWidth * 0);
        main.playerY = (main.canvisHeight * 0); //can be 0
    }
}