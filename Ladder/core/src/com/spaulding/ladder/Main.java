package com.spaulding.ladder;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.spaulding.ladder.Screens.MenuScreen;

public class Main extends Game {
	public SpriteBatch batcher;

	@Override
	public void create() {
		batcher = new SpriteBatch();
		com.spaulding.ladder.Utils.Assets.load();
		setScreen(new MenuScreen(this));
	}
	
	@Override
	public void render(){
		super.render();
	}
}
