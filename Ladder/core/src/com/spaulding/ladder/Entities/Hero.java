package com.spaulding.ladder.Entities;

/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public class Hero extends Entity{
    public static final float CHARACTER_WIDTH = 70f, CHARACTER_HEIGHT = 130f;

    public float state_time;

    public Hero(float x, float y){
        super(x, y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
        state_time = 1;
    }

    public void update(float delta){
        state_time += delta;
    }
}
