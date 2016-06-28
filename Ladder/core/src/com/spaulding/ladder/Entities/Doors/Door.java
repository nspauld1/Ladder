package com.spaulding.ladder.Entities.Doors;

import com.badlogic.gdx.graphics.g2d.Sprite;
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

    public DoorType dType;

    public float state_time;

    public Door(float x, float y, DoorType dType){
        super(x, y, DOOR_WIDTH, DOOR_HEIGHT, type, false,
                Constants.BIT_SENSORS, ((short) (Constants.BIT_BLOCKERS | Constants.BIT_PLAYER)),
                "door");

        this.dType = dType;

        state_time = 1;
    }

    public void defineSprite(Sprite sprite) {
        sprite.setSize(DOOR_WIDTH / PPM, DOOR_HEIGHT / PPM);
    }

    public void update(float delta){
        state_time += delta;
    }
}
