package com.spaulding.ladder.Entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Utils.Assets;
import com.spaulding.ladder.Utils.Constants;

import static com.spaulding.ladder.Utils.Constants.BIT_PLAYER;
import static com.spaulding.ladder.Utils.Constants.PPM;

/**
 * Created by jared on 5/19/2016.
 */
public class Ladder extends Entity {
    public static final float LADDER_WIDTH = 90f;

    public enum LadderLength {ONE, TWO, THREE, FOUR, FIVE, SIX}
    public LadderLength length;

    private static final BodyType type = BodyType.STATIC;
    private static final boolean canRotate =false;

    public float state_time;

    public Ladder(float x, float y, float height, LadderLength length) {
        super(x, y, LADDER_WIDTH, height, type, canRotate,
                Constants.BIT_SENSORS, ((short) (Constants.BIT_BLOCKERS | Constants.BIT_PLAYER)),
                "ladder");

        this.length = length;
        switch (length) {
            case ONE:
                sprite = new Sprite(Assets.ladders[0]);
                break;
            case TWO:
                sprite = new Sprite(Assets.ladders[1]);
                break;
            case THREE:
                sprite = new Sprite(Assets.ladders[2]);
                break;
            case FOUR:
                sprite = new Sprite(Assets.ladders[3]);
                break;
            case FIVE:
                sprite = new Sprite(Assets.ladders[4]);
                break;
            case SIX:
                sprite = new Sprite(Assets.ladders[5]);
                break;
        }
        sprite.setPosition(x / PPM, y / PPM);
        sprite.setSize(LADDER_WIDTH / PPM, height / PPM);

        state_time = 1;
    }

    public void update(float delta){
        state_time += delta;
    }
}
