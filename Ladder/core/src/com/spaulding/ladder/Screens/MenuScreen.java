package com.spaulding.ladder.Screens;

import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/18/2016.
 */
public class MenuScreen extends LadderScreen {
    Main game;

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

    }

    public void update(){

    }


}
