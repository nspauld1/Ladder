package com.spaulding.ladder.Entities.Floors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Entities.BodyType;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Utils.Constants;

import static com.spaulding.ladder.Utils.Constants.PPM;

/**
 * Created by jared on 5/20/2016.
 */
public class Floor extends Entity {
    public static final float FLOOR_HEIGHT = 45f;
    public float width;
    private static final BodyType type = BodyType.STATIC;

    public FloorType fType;
    private static final boolean canRotate = false;

    public float state_time;

    public Floor(float x, float y, float width, FloorType fType){
        super(x,y,width,FLOOR_HEIGHT, type, canRotate,
                Constants.BIT_BLOCKERS, Constants.BIT_PLAYER,
                "ground");

        this.fType = fType;
        this.width = width;
        state_time = 1;
    }

    public void defineSprite(Sprite sprite) {
        sprite. setSize(width / PPM, FLOOR_HEIGHT / PPM);
    }

    public void update(float delta){
        state_time += delta;
    }
}
