package com.spaulding.ladder;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.spaulding.ladder.Entity.Ladder;
import com.spaulding.ladder.Entity.Object;
import com.spaulding.ladder.Screen.MenuScreen;
import com.spaulding.ladder.Screen.ScreenManager;

public class Main implements ApplicationListener {
	public Stage stage;
	public static int WIDTH = 1080, HEIGHT = 640;

	@Override
	public void create () {
		stage = new Stage();
		Object ladder1 = new Ladder(Ladder.LadderType.NORMAL);
		stage.addActor(ladder1);
		ScreenManager.setScreen(new MenuScreen());
	}

	@Override
	public void render () {
		if (ScreenManager.getCurrentScreen() != null){
			ScreenManager.getCurrentScreen().render(stage);
		}
	}

	@Override
	public void resize(int width, int height) {
		if (ScreenManager.getCurrentScreen() != null){
			ScreenManager.getCurrentScreen().resize(width, height);
		}
	}

	@Override
	public void pause() {
		if (ScreenManager.getCurrentScreen() != null){
			ScreenManager.getCurrentScreen().pause();
		}
	}

	@Override
	public void resume() {
		if (ScreenManager.getCurrentScreen() != null){
			ScreenManager.getCurrentScreen().resume();
		}
	}

	@Override
	public void dispose() {
		if (ScreenManager.getCurrentScreen() != null){
			ScreenManager.getCurrentScreen().dispose();
		}
	}
}
