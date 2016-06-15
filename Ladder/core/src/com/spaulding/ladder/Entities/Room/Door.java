package com.spaulding.ladder.Entities.Room;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Utils.Assets;
import com.spaulding.ladder.Entities.BodyType;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Utils.Constants;

import static com.spaulding.ladder.Utils.Constants.PPM;
/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public class Door extends Entity {
    public static final float DOOR_WIDTH = 90, DOOR_HEIGHT = 180;
    private static final BodyType type = BodyType.KINEMATIC;

    public enum DoorType {LOCKED, UNLOCKED, OPENED}
    public DoorType dType;

    public float state_time;

    public Door(float x, float y, DoorType dType){
        super(x, y, DOOR_WIDTH, DOOR_HEIGHT, type, false,
                Constants.BIT_SENSORS, Constants.BIT_BLOCKERS,
                "door");

        this.dType = dType;
        switch (dType) {
            case UNLOCKED:
                sprite = new Sprite(Assets.door_unlocked);
                break;
            case LOCKED:
                sprite = new Sprite(Assets.door_locked);
                break;
            case OPENED:
                sprite = new Sprite(Assets.door_opened);
                break;
        }
        sprite.setSize(DOOR_WIDTH / PPM, DOOR_HEIGHT / PPM);
        state_time = 1;
    }

    public void update(float delta){
        state_time += delta;
    }
}
