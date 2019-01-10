package com.mygdx.game;

public class WorldController { //can pe package private
    public static void Scroll() { //can be package private whatever the heck that is


        if (main.backgroundSpriteX <= main.canvisWidth && main.backgroundSpriteX >= 0) { // if background 1 is on screen
            main.backgroundSprite2X = main.backgroundSpriteX - main.canvisWidth;
        } else if (main.backgroundSpriteX >= main.canvisWidth) { //if blank shows on the left side of the canvis
            main.backgroundSpriteX = 0;
            main.backgroundSprite2X = main.backgroundSpriteX - main.canvisWidth;
        } else if (main.backgroundSpriteX <= 0) { //if blank shows on right side of the canvis
            main.backgroundSprite2X = 0;
            main.backgroundSpriteX = main.canvisWidth;
        }
    }
}
