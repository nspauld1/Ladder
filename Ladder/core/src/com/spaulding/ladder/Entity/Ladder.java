package com.spaulding.ladder.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by jared on 5/14/2016.
 */
public class Ladder extends Object{
    public enum LadderType {NORMAL}
    public LadderType type;
    Sprite ladder;
    Texture texture;

    public Ladder(LadderType type){
        super();
        this.type = type;

        switch (type){
            case NORMAL:
                texture = new Texture("ladder.png");
                ladder = new Sprite(texture);
                break;
            default:

        }
        super.setObject(ladder);
    }

}
