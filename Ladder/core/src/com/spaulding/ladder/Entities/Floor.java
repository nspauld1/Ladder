package com.spaulding.ladder.Entities;

/**
 * Created by jared on 5/20/2016.
 */
public class Floor extends Entity {
    private static final float FLOOR_WIDTH = 360f, FLOOR_HEIGHT = 45f;

    public enum FloorType {CONCRETE,WOOD,GROUND}
    public FloorType type;

    public float state_time;

    public Floor(float x, float y, FloorType type){
        super(x,y,FLOOR_WIDTH,FLOOR_HEIGHT);
        state_time = 1;
        this.type = type;
    }

    public void update(float delta){
        state_time += delta;
    }
}
