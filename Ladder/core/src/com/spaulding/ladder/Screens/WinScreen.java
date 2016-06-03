package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 6/2/2016.
 */
public class WinScreen extends LadderScreen{
    Main game;

    public WinScreen(Main game){
        super(game);
        this.game = game;
    }

    public void render(float delta) {
        update();
        draw();
    }

    public void draw(){
        Gdx.gl.glClearColor(0f,0f,0f,0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void update(){

    }
}
