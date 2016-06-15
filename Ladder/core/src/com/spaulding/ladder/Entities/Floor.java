package com.spaulding.ladder.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Utils.Assets;
import com.spaulding.ladder.Utils.Constants;

import static com.spaulding.ladder.Utils.Constants.BIT_SENSORS;
import static com.spaulding.ladder.Utils.Constants.PPM;

/**
 * Created by jared on 5/20/2016.
 */
public class Floor extends Entity {
    public static final float FLOOR_HEIGHT = 45f;
    private static final BodyType type = BodyType.STATIC;

    public FloorType fType;
    private static final boolean canRotate = false;

    public float state_time;

    public Floor(float x, float y, float width, FloorType fType){
        super(x,y,width,FLOOR_HEIGHT, type, canRotate,
                Constants.BIT_BLOCKERS, Constants.BIT_PLAYER,
                "ground");

        this.fType = fType;
        switch (fType) {
            case CONCRETE_SMALL:
                sprite = new Sprite(Assets.floors[0]);
                break;
            case CONCRETE_MEDIUM:
                sprite = new Sprite(Assets.floors[1]);
                break;
            case CONCRETE_LONG:
                sprite = new Sprite(Assets.floors[2]);
                break;
            case WOOD_SMALL:
                sprite = new Sprite(Assets.floors[3]);
                break;
            case WOOD_MEDIUM:
                sprite = new Sprite(Assets.floors[4]);
                break;
            case WOOD_LONG:
                sprite = new Sprite(Assets.floors[5]);
                break;
            case GROUND_SMALL:
                sprite = new Sprite(Assets.floors[6]);
                break;
            case GROUND_MEDIUM:
                sprite = new Sprite(Assets.floors[7]);
                break;
            case GROUND_LONG:
                sprite = new Sprite(Assets.floors[8]);
                break;
        }
        sprite. setSize(width / PPM, FLOOR_HEIGHT / PPM);
        state_time = 1;
    }

    public void update(float delta){
        state_time += delta;
    }
}
