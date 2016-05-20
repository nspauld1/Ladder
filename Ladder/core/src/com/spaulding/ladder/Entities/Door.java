package com.spaulding.ladder.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public class Door extends Entity {
    public enum doorState {LOCKED, UNLOCKED}
    public enum doorContents {KEY, GUN, BOMB, SHOES}

    public doorState state;
    public doorContents contents;

    Sprite door = new Sprite();

    public Door(doorState state, doorContents contents) {
        super();
        this.state = state;
        this.contents = contents;

        switch (state){
            case LOCKED:
                break;
            case UNLOCKED:
                break;
            default:
        }

        switch (contents){
            case KEY:
                break;
            case GUN:
                break;
            case BOMB:
                break;
            case SHOES:
                break;
            default:
        }

        super.setEntity(door);
    }
}
