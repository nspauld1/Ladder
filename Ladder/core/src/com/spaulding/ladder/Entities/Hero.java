package com.spaulding.ladder.Entities;

/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public class Hero extends DynamicEntity{
    public static final float HERO_WIDTH = 70f, HERO_HEIGHT = 130f;

    public enum HeroState {HERO_STATE_CLIMB, HERO_STATE_FALL, HERO_STATE_COLLECT,
                            HERO_STATE_COLLIDE}
    public HeroState state;

    public float state_time;

    public Hero(float x, float y){
        super(x, y, HERO_WIDTH, HERO_HEIGHT);
        state = HeroState.HERO_STATE_COLLIDE;
        state_time = 1;
    }

    public void update(float delta){
        state_time += delta;
    }
}
