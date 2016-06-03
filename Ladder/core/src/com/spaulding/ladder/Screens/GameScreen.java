package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.spaulding.ladder.InputController;
import com.spaulding.ladder.Levels.LevelController;
import com.spaulding.ladder.Levels.Level1;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/27/2016.
 */
public class GameScreen extends LadderScreen {
    Main game;
    LevelController determined_level;

    public enum GameState {GAME_STATE_PLAY, GAME_STATE_PAUSE, GAME_STATE_WIN, GAME_STATE_LOOSE,
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
                determined_level.draw();
                determined_level.update();
                determined_level.checkCollisions();
                inputUpdater();
                break;
            case GAME_STATE_PAUSE:
                break;
            case GAME_STATE_QUIT:
                game.setScreen(new MenuScreen(game));
                break;
            case GAME_STATE_WIN:
                game.setScreen(new WinScreen(game));
                break;
            case GAME_STATE_LOOSE:
                break;
        }
    }

    private void inputUpdater(){
        Gdx.input.setInputProcessor(new InputController() {
            @Override
            public boolean keyDown(int keycode){
                switch (keycode) {
                    case Keys.ESCAPE:
                        state = GameState.GAME_STATE_QUIT;
                        break;
                    case Keys.A:
                        break;
                    case Keys.D:
                        break;
                    case Keys.S:
                        break;
                    case Keys.W:
                        break;
                }
                return true;
            }
        });
    }
}
