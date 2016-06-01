package com.spaulding.ladder.Entities.Room;


import com.spaulding.ladder.Entities.DynamicEntity;

/**
 * Created by jared on 5/20/2016.
 */
public class Item extends DynamicEntity{
    public static float item_width, item_length;

    public enum ItemType {KEY}
    public ItemType type;

    public float state_time;

    public Item (float x, float y, ItemType type){
        super(x, y, item_width, item_length);
        this.type = type;

        switch (type) {
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
