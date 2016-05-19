package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/18/2016.
 */
public class HighScoreScreen extends LadderScreen {
    Main game;

    public HighScoreScreen(Main game){
        super(game);
        this.game = game;
    }

    public void render(float delta){
        update();
        draw();
    }

    public void update(){

    }

    public void draw(){
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }
}
