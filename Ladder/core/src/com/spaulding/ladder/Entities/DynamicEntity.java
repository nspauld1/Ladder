package com.spaulding.ladder.Entities;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by jared on 5/26/2016.
 */
public class DynamicEntity extends Entity {

    public final Vector2 velocity;
    public final Vector2 accel;

    public DynamicEntity (float x, float y, float width, float height) {
        super(x, y, width, height);
        velocity = new Vector2();
        accel = new Vector2();
    }
}
