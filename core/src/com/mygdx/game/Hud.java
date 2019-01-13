package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

@SuppressWarnings("unused")
public class Hud implements Disposable{
	public Stage stage;
	private Viewport viewport;
	
	private float timeCount;
	
	Label playerLabel;
	
	public  Hud(SpriteBatch sb) {
		timeCount = 0;
		
		viewport = new FitViewport(main.V_WIDTH, main.V_HEIGHT, new OrthographicCamera());
		stage = new Stage(viewport, sb);
		
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		
		playerLabel = new Label("BURNING SHOOTER", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		table.add(playerLabel);
		
		stage.addActor(table);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
}
