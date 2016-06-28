package com.spaulding.ladder.Entities.Enemies;

import com.spaulding.ladder.Entities.BodyType;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Utils.Constants;

/**
 * Created by jared on 6/24/2016.
 */
public class Enemy extends Entity {
    public static final float WIDTH = 50, HEIGHT = 100;

    private static final BodyType body_type = BodyType.DYNAMIC;

    public float state_time;

    public Enemy (float x, float y) {
        super (x, y, WIDTH, HEIGHT, body_type, false,
                Constants.BIT_PLAYER, Constants.BIT_BLOCKERS,
                "enemy");
        state_time = 0;
    }

    public void update(float delta) {
        state_time += delta;
    }
}
