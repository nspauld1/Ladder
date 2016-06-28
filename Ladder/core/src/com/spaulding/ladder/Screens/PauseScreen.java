package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/18/2016.
 */
public class PauseScreen extends LadderScreen {
    Main game;
    GameScreen gameScreen;

    public PauseScreen(Main game, GameScreen gameScreen){
        super(game);
        this.game = game;
        this.gameScreen = gameScreen;
    }

    public void render(float delta){
        update();
        draw();
    }

    public  void update(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            game.setScreen(gameScreen);
            GameScreen.state = GameScreen.GameState.GAME_STATE_PLAY;
        }
    }

    public void draw(){

    }

}
