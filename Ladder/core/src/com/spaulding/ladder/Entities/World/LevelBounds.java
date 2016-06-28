package com.spaulding.ladder.Entities.World;

import com.spaulding.ladder.Entities.BodyType;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Utils.Constants;

/**
 * Created by jared on 6/28/2016.
 */
public class LevelBounds extends Entity {
    public static float width, height;
    public static final BodyType type = BodyType.STATIC;

    public LevelBounds(float x, float y, float width, float height) {
        super(x,y,width,height,type,false, Constants.BIT_BLOCKERS, Constants.BIT_PLAYER,
                "bounds");

        this.width = width;
        this.height = height;
        sprite = null;
    }
}
