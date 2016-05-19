package com.spaulding.ladder.Screens;

import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/18/2016.
 */
public class PauseScreen extends LadderScreen {
    Main game;

    public PauseScreen(Main game){
        super(game);
        this.game = game;
    }

    public void render(float delta){
        update();
        draw();
    }

    public  void update(){

    }

    public void draw(){

    }

}
