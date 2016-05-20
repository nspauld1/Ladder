package com.spaulding.ladder.Entities.Room;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Entities.Entity;

/**
 * Created by jared on 5/20/2016.
 */
public class Items extends Entity {
    public enum DoorContents {KEY, GUN, BOMB, SHOES}
    public DoorContents contents;

    Sprite item;

    public Items(DoorContents contents){
        super();
        this.contents = contents;

        switch(contents){
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
        super.setEntity(item);
    }
}
