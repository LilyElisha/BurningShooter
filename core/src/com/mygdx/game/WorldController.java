package com.mygdx.game;

public class WorldController { //can pe package private
	public static void Scroll(){ //can be package private whatever the heck that is
		
		main.backgroundSpriteX = main.playerX;

		if(main.playerX == main.backgroundSpriteX) { //always true
			main.backgroundSprite2X = main.backgroundSpriteX - main.canvisWidth;
		}
				
		if(main.playerX == main.backgroundSprite2X) {
			main.backgroundSpriteX = main.backgroundSprite2X - main.canvisWidth;
		}
		
		if(main.playerX == main.backgroundSprite2X-main.canvisWidth) {
			main.backgroundSprite3X = main.backgroundSprite2X - main.canvisWidth;
		}
		
		//
		
		//if(main.playerX/main.canvisWidth )
		
		//
	}
}
