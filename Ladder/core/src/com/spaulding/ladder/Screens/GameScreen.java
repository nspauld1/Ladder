package com.spaulding.ladder.Screens;

import com.spaulding.ladder.Levels.Level1;
import com.spaulding.ladder.Levels.LevelController;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/27/2016.
 */
public class GameScreen extends LadderScreen {
    Main game;
    LevelController determined_level;

    public enum GameState {GAME_STATE_PLAY, GAME_STATE_PAUSE, GAME_STATE_WIN, GAME_STATE_LOSE,
                            GAME_STATE_QUIT}

    public static GameState state;

    public GameScreen(Main game, int determined_level_num){
        super(game);
        this.game = game;

        state = GameState.GAME_STATE_PLAY;

        switch (determined_level_num){
            case 1:
                determined_level = new Level1();
                break;
            default: System.out.print("an error occurred in controller_level");
        }
    }

    public void render(float delta){
        update();
        draw();
    }

    public void draw(){

    }

    public void update(){
        switch (state) {
            case GAME_STATE_PLAY:
                determined_level.render();
                break;
            case GAME_STATE_PAUSE:
                game.setScreen(new PauseScreen(game, this));
                break;
            case GAME_STATE_QUIT:
                game.setScreen(new MenuScreen(game));
                break;
            case GAME_STATE_WIN:
                game.setScreen(new WinScreen(game));
                break;
            case GAME_STATE_LOSE:
                break;
        }
    }
}
