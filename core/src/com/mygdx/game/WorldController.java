package com.mygdx.game;

public class WorldController { //can pe package private
    public static void Scroll() { //can be package private whatever the heck that is

        main.backgroundSpriteX = main.playerX;

        if (main.playerX == main.backgroundSpriteX) { //always true
            main.backgroundSprite2X = main.backgroundSpriteX - main.canvisWidth;
        }

        if (main.playerX == main.backgroundSprite2X) {
            main.backgroundSpriteX = main.backgroundSprite2X - main.canvisWidth;
        }

        if (main.playerX == main.backgroundSprite2X - main.canvisWidth) {
            main.backgroundSprite3X = main.backgroundSprite2X - main.canvisWidth;
        }

        // if the backround x is at the start of the canvis then we want to put the other canvis behind it and doing it by taking the canvis x and dividing is by the canvis width and if we get a whole number then we will put the one down accordingly weather its even or odd like if the x is 8000 then 8000/800(canviswidth) will br 10 and sence its even it will move backround 2 behind backround one

        //

        //
    }
}
