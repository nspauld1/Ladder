package com.spaulding.ladder.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Assets;

/**
 * Created by jared on 5/19/2016.
 */
public class Ladder extends Entity {
    public enum LadderLength {ONE, TWO, THREE, FOUR, FIVE, SIX}

    public LadderLength length;

    Sprite ladder = new Sprite();

    public Ladder(LadderLength length){
        super();
        this.length = length;

        switch(length){
            case ONE:
                ladder = new Sprite(Assets.ladders[0]);
                break;
            case TWO:
                ladder = new Sprite(Assets.ladders[1]);
                break;
            case THREE:
                ladder = new Sprite(Assets.ladders[2]);
                break;
            case FOUR:
                ladder = new Sprite(Assets.ladders[3]);
                break;
            case FIVE:
                ladder = new Sprite(Assets.ladders[4]);
                break;
            case SIX:
                ladder = new Sprite(Assets.ladders[5]);
                break;
            default:
        }

        super.setEntity(ladder);
    }
}
