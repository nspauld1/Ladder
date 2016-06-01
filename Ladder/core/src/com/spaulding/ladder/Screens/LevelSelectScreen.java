package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/18/2016.
 */
public class LevelSelectScreen extends LadderScreen{
    Main game;

    public LevelSelectScreen(Main game){
        super(game);
        this.game = game;
    }

    public void render(float delta){
        update();
        draw();
    }

    public void update(){
        game.setScreen( new GameScreen(game,1));
    }

    public void draw(){
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
