package com.spaulding.ladder.Entities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by jared on 5/26/2016.
 */
public class DynamicEntity extends Entity {

    World world;

    public DynamicEntity (float x, float y, float width, float height) {
        super(x, y, width, height);
        world = new World (new Vector2(0, - 98f), true);
    }
}
