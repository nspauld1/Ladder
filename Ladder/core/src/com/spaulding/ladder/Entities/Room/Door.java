package com.spaulding.ladder.Entities.Room;

import com.spaulding.ladder.Entities.Entity;

/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public class Door extends Entity{
    public static final float DOOR_WIDTH = 90, DOOR_HEIGHT = 180;

    public enum DoorType {LOCKED, UNLOCKED, OPEN}
    public DoorType type;

    public float state_time;

    public Door(float x, float y, DoorType type){
        super(x, y, DOOR_WIDTH, DOOR_HEIGHT);
        state_time = 1;
        this.type = type;
    }

    public void update(float delta){
        state_time += delta;
    }
}
