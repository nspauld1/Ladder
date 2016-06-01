package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.spaulding.ladder.Levels.Level;
import com.spaulding.ladder.Levels.Level1;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/27/2016.
 */
public class GameScreen extends LadderScreen {
    Main game;
    Level level;

    public GameScreen(Main game, int level_num){
        super(game);
        this.game = game;

        switch (level_num){
            case 1:
                level = new Level1();
                break;
            default: System.out.print("an error occurred in level");
        }
    }

    public void render(float delta){
        update();
        draw();
        level.hero.update(delta);
    }

    public void draw(){
        Gdx.gl.glClearColor(0f,0f,0f,0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        level.draw();
        level.checkCollisions();
    }

    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            level.hero.position.x -= 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            level.hero.position.x += 5;
        }
        level.hero.bounds.setPosition(level.hero.position.x,
                level.hero.position.y);
    }
}
