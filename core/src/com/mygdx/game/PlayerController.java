package com.mygdx.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Event;

@SuppressWarnings("unused")
public class PlayerController {

    public void Controller() {

        main.player = new Sprite(main.texture);
        main.playerX = (main.canvisWidth * 0);
        main.playerY = main.canvisHeight; //can be 0
    }

    public static void keyInput() {
        if (Gdx.input.isKeyPressed(Keys.D)) {
            main.playerX++;
            main.backgroundSpriteX++;
        }
        if (Gdx.input.isKeyPressed(Keys.A)) {
            main.playerX--;
            main.backgroundSpriteX--;
        }
    }
}