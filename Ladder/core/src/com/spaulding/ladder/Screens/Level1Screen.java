package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.spaulding.ladder.Animation;
import com.spaulding.ladder.Assets;
import com.spaulding.ladder.Levels.Level1;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/25/2016.
 */
public class Level1Screen extends LadderScreen{
    Main game;
    Level1 level;
    SpriteBatch batcher;

    public Level1Screen(Main game){
        super(game);
        level = new Level1();
        batcher = new SpriteBatch();
    }

    public void render(float delta){
        update();
        draw();
        level.key1.update(delta);
    }

    public void update(){

    }

    public void draw(){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();

        batcher.draw(Assets.floor_ground, level.floor1.position.x, level.floor1.position.y);
        batcher.draw(Assets.floor_ground, level.floor2.position.x, level.floor2.position.y);
        batcher.draw(Assets.floor_wood, level.floor3.position.x, level.floor3.position.y);
        batcher.draw(Assets.floor_wood, level.floor4.position.x, level.floor4.position.y);
        batcher.draw(Assets.floor_wood, level.floor5.position.x, level.floor5.position.y);
        batcher.draw(Assets.floor_wood, level.floor6.position.x, level.floor6.position.y);


        batcher.draw(Assets.ladders[1], level.ladder1.position.x, level.ladder1.position.y);
        batcher.draw(Assets.ladders[3], level.ladder2.position.x, level.ladder2.position.y);
        batcher.draw(Assets.ladders[3], level.ladder3.position.x, level.ladder3.position.y);

        batcher.draw(Assets.door_locked, level.door1.position.x, level.door1.position.y);

        for (int i = 0 ; i < level.keys.size(); i++){
            level.key1 = level.keys.get(i);
            TextureRegion keyFrame = Assets.key_anim.getKeyFrame(level.key1.state_time, Animation.ANIMATION_LOOPING);
            batcher.draw(keyFrame,level.key1.position.x,level.key1.position.y);
        }

        batcher.end();
    }
}
