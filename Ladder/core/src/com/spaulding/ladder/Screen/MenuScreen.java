package com.spaulding.ladder.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
/**
 * Created by jared on 5/14/2016.
 */
public class MenuScreen extends Screen {

    @Override
    public void dispose() {

    }

    @Override
    public void create() {
    }

    @Override
    public void render(Stage stage) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
