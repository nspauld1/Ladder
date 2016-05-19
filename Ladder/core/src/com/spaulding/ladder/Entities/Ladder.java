package com.spaulding.ladder.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Assets;

/**
 * Created by jared on 5/19/2016.
 */
public class Ladder extends Entity {
    public enum LadderType {NORMAL, LOCKED}
    public enum LadderLength {SHORT, MEDIAM, LONG}

    public LadderType type;
    public LadderLength length;

    Sprite ladder = new Sprite();

    public Ladder(LadderType type, LadderLength length){
        super();
        this.type = type;
        this.length = length;

        switch(type){
            case NORMAL:
                break;
            case LOCKED:
                break;
            default:
        }

        switch(length){
            case SHORT:
                break;
            case MEDIAM:
                break;
            case LONG:
                break;
            default:
        }

        super.setEntity(ladder);
    }
}
