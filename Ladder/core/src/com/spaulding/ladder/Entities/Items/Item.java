package com.spaulding.ladder.Entities.Items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Animation;
import com.spaulding.ladder.Entities.BodyType;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Utils.Assets;
import com.spaulding.ladder.Utils.Constants;

import static com.spaulding.ladder.Utils.Constants.PPM;

/**
 * Created by jared on 5/20/2016.
 */
public class Item extends Entity {
    public static float item_width, item_height;

    private static final BodyType type = BodyType.KINEMATIC;

    public ItemType iType;

    public float state_time;

    public Item (float x, float y, ItemType iType){
        super(x, y, item_width, item_height, type, false,
                Constants.BIT_SENSORS, ((short) (Constants.BIT_BLOCKERS | Constants.BIT_PLAYER)),
                "item");
        this.iType = iType;

        switch (iType) {
            case KEY:
                item_width = 25;
                item_height = 75;
                state_time = 0;
                sprite = new Sprite(Assets.key_anim.getKeyFrame(state_time, Animation.ANIMATION_LOOPING));
                break;
        }
        sprite.setSize(item_width / PPM, item_height / PPM);
    }

    public void update(float delta, ItemType type){
        state_time += delta;
        switch (type) {
            case KEY:
                Sprite sprite2;
                sprite2 = new Sprite(Assets.key_anim.getKeyFrame(state_time, Animation.ANIMATION_LOOPING));
                sprite2.setSize(item_width / PPM, item_height / PPM);
                sprite.set(sprite2);
                break;
        }
    }
}
