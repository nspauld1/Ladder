package com.spaulding.ladder.Entities;

/**
 * Created by jared on 5/19/2016.
 */
public class Ladder extends Entity{
    public static final float LADDER_WIDTH = 45F;

    public float state_time;

    public Ladder(float x, float y, float height) {
        super(x, y, LADDER_WIDTH, height);
        state_time = 1;
    }

    public void update(float delta){
        state_time += delta;
    }
}
