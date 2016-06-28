package com.spaulding.ladder.Entities.Ladders;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Entities.BodyType;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Utils.Constants;

import static com.spaulding.ladder.Utils.Constants.PPM;

/**
 * Created by jared on 5/19/2016.
 */
public class Ladder extends Entity {
    public static final float LADDER_WIDTH = 90f;
    public float height;

    public LadderLength length;

    private static final BodyType type = BodyType.KINEMATIC;
    private static final boolean canRotate =false;

    public float state_time;

    public Ladder(float x, float y, float height, LadderLength length) {
        super(x, y, LADDER_WIDTH, height, type, canRotate,
                Constants.BIT_SENSORS, ((short) (Constants.BIT_BLOCKERS | Constants.BIT_PLAYER)),
                "ladder");

        this.length = length;
        this.height = height;

        state_time = 1;
    }

    public void defineSprite(Sprite sprite) {
        sprite.setSize(LADDER_WIDTH / PPM, height / PPM);
    }

    public void update(float delta){
        state_time += delta;
    }
}
