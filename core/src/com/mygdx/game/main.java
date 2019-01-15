package com.mygdx.game;

//import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.physics.box2d.*;


public class main extends Game{
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float PPM = 100;
	
	public static final short PLAYER_BIT = 0x0001;
	public static final short GROUND_BIT = 0x0002;
	public static final short ENEMY_BIT = 0x0004; 
	public static final short OBJECT_BIT = 0x0008;
	public static final short PROJECTILE_BIT = 0x0016;
	
	public SpriteBatch batch;
    

    public void create() {
        batch = new SpriteBatch();
        setScreen(new PlayScreen(this));
    }

    public void render() {
        super.render();
    }


    public void resize(int width, int height) {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
    }

}
