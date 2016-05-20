package com.spaulding.ladder.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Assets;

/**
 * Created by jared on 5/20/2016.
 */
public class Floor extends Entity {
    public enum FloorType {CONCRETE, WOOD, GROUND}
    public FloorType type;

    Sprite floor;

    public Floor(FloorType type){
        super();
        this.type = type;

        switch (type){
            case CONCRETE:
                floor = new Sprite(Assets.floor_concrete);
                break;
            case WOOD:
                floor = new Sprite(Assets.floor_wood);
                break;
            case GROUND:
                floor = new Sprite(Assets.floor_ground);
                break;
            default:
                floor = new Sprite(Assets.floor_ground);
        }
        super.setEntity(floor);
    }
}
