package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.spaulding.ladder.Assets;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/18/2016.
 */
public class MenuScreen extends LadderScreen {
    Main game;

    private final float PLAY_WIDTH = 100, SETTINGS_WIDTH = 200, HIGH_SCORE_WIDTH = 250,
                        ABOUT_WIDTH = 150;
    private final float WIDTH = 640, HEIGHT = 900;

    public MenuScreen(Main game){
        super(game);
        this.game = game;
    }

    @Override
    public void render(float delta){
        update();
        draw();
    }

    public void draw(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batcher.begin();
        game.batcher.draw(Assets.play,(WIDTH / 2) - (PLAY_WIDTH / 2),HEIGHT - 200);
        game.batcher.draw(Assets.settings,(WIDTH / 2) - (SETTINGS_WIDTH / 2), HEIGHT - 300);
        game.batcher.draw(Assets.high_score,(WIDTH / 2) - (HIGH_SCORE_WIDTH / 2),HEIGHT - 400);
        game.batcher.draw(Assets.about,(WIDTH / 2) - (ABOUT_WIDTH / 2), HEIGHT - 500);
        game.batcher.end();
    }

    public void update(){

    }


}
