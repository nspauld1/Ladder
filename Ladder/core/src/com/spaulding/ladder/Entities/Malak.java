package com.spaulding.ladder.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public class Malak extends Entity {
    public enum PlayerMovementSpeed {SLOW, NORMAL, FAST}

    public PlayerMovementSpeed speed;

    Sprite Malak = new Sprite();

    public Malak(PlayerMovementSpeed speed){
        super();
        this.speed = speed;

        switch (speed){
            case SLOW :
                break;
            case NORMAL:
                break;
            case FAST:
                break;
            default:
        }

        super.setEntity(Malak);

    }
}
