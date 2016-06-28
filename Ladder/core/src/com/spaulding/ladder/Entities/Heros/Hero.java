package com.spaulding.ladder.Entities.Heros;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.spaulding.ladder.Entities.BodyType;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Utils.Assets;
import com.spaulding.ladder.Utils.Constants;

/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public class Hero extends Entity {
    public static final float HERO_WIDTH = 70f, HERO_HEIGHT = 130f;

    private static final BodyType type = BodyType.DYNAMIC;
    private static final boolean canRotate = false;

    public float state_time;

    public Hero(float x, float y){
        super(x, y, HERO_WIDTH, HERO_HEIGHT, type, canRotate,
                Constants.BIT_PLAYER, ((short) (Constants.BIT_BLOCKERS | Constants.BIT_SENSORS) ),
                "hero");
        sprite = new Sprite(Assets.hero);

        state_time = 1;
    }

    public void update(float delta){
        state_time += delta;
    }
}
