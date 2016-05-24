package com.spaulding.ladder.Entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by jared on 5/19/2016.
 */
public class Entity {
    public final Rectangle bounds;
    public final Vector2 position;

    public Entity(float x, float y, float width, float height) {

        this.position = new Vector2(x, y);
        this.bounds = new Rectangle(x - width / 2, y - height / 2, width, height);
    }
}
