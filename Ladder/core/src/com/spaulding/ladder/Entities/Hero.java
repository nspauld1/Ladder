package com.spaulding.ladder.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.spaulding.ladder.Levels.Level1;

/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public class Hero extends DynamicEntity{
    public static final float HERO_WIDTH = 70f, HERO_HEIGHT = 15f;
    public static final int HERO_STATE_CLIMB = 0;
    public static final int HERO_STATE_FALL = 1;
    public static final int HERO_STATE_COLLECT = 2;
    public static final int HERO_STATE_COLLIDE = 3;

    public int state;

    public float state_time;

    public Hero(float x, float y){
        super(x, y, HERO_WIDTH, HERO_HEIGHT);
        state = HERO_STATE_COLLIDE;
        state_time = 1;
    }

    public void update(float delta){

        switch (state) {
            case HERO_STATE_FALL:
                velocity.add(0, Level1.gravity.y * delta);
                position.add(velocity.x, velocity.y);
                bounds.setPosition(position);
                break;
            case HERO_STATE_CLIMB:
                if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
                    position.y -= 2;
                }
                if (Gdx.input.isKeyPressed(Input.Keys.UP)){
                    position.y += 2;
                }
                break;
            case HERO_STATE_COLLECT:
                break;
            case HERO_STATE_COLLIDE:
                break;
        }
        state_time += delta;
    }
}
