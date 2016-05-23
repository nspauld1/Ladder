package com.spaulding.ladder.Entities.Room;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Assets;
import com.spaulding.ladder.Entities.Entity;

/**
 * Created by jared on 5/20/2016.
 */
public class Items extends Entity {
    public enum DoorContents {KEY, GUN, BOMB, SHOES}
    public DoorContents contents;

    Sprite item;
    public float stateTime;

    public Items(DoorContents contents){
        super();
        this.contents = contents;

        switch(contents){
            case KEY:
                stateTime = 0;
                item = new Sprite(Assets.key_anim.getKeyFrame(stateTime,0));
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

    public void update(float deltaTime){
        stateTime += deltaTime;
    }
}
