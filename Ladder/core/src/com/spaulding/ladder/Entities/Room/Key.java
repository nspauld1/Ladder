package com.spaulding.ladder.Entities.Room;

import com.spaulding.ladder.Entities.Entity;

/**
 * Created by jared on 5/24/2016.
 */
public class Key extends Entity {
    private static final float KEY_WIDTH = 150, KEY_HEIGHT = 150;

    public float state_time;

    public Key(float x, float y){
        super(x,y,KEY_WIDTH,KEY_HEIGHT);
        state_time = 0;
    }

    public void update(float delta){
        state_time += delta;
    }
}
