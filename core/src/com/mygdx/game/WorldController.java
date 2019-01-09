package com.mygdx.game;

public class WorldController {
	public static void Scroll(){
		
		main.backgroundSpriteX = main.playerX;

		if(main.playerX == main.backgroundSpriteX) {
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
