package com.spaulding.ladder.Entities;

/**
 * Created by jared on 5/19/2016.
 */
public class Ladder extends Entity{
    public static final float LADDER_WIDTH = 90f;

    public enum LadderLength {ONE, TWO, THREE, FOUR, FIVE, SIX}
    public LadderLength length;

    public float state_time;

    public Ladder(float x, float y, float height, LadderLength length) {
        super(x, y, LADDER_WIDTH, height);
        state_time = 1;
        this.length = length;
    }

    public void update(float delta){
        state_time += delta;
    }
}
