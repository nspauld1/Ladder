package com.spaulding.ladder.Entities.Room;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Assets;
import com.spaulding.ladder.Entities.Entity;

/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public class Door extends Entity {
    public enum DoorState {LOCKED, UNLOCKED}

    public DoorState state;

    Sprite door;

    public Door(DoorState state) {
        super();
        this.state = state;

        switch (state){
            case LOCKED:
                door = new Sprite(Assets.door_locked);
                break;
            case UNLOCKED:
                door = new Sprite(Assets.door_unlocked);
                break;
            default:
        }

        super.setEntity(door);
    }
}
