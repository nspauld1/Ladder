package com.spaulding.ladder.Entities.Room;


import com.spaulding.ladder.Entities.BodyType;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Utils.Constants;

/**
 * Created by jared on 5/20/2016.
 */
public class Item extends Entity {
    public static float item_width, item_length;

    private static final BodyType type = BodyType.KINEMATIC;

    public enum ItemType {KEY}
    public ItemType iType;

    public float state_time;

    public Item (float x, float y, ItemType iType){
        super(x, y, item_width, item_length, type, false,
                Constants.BIT_SENSORS, Constants.BIT_BLOCKERS,
                "item");
        this.iType = iType;

        switch (iType) {
            case KEY:
                item_width = 150;
                item_length = 150;
                state_time = 0;
                break;
        }
    }

    public void update(float delta){
        state_time += delta;
    }
}
