package com.spaulding.ladder.Entity;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by jared on 5/14/2016.
 */
public class Object extends Actor {
    private Sprite object;

    public void setObject(Sprite sprite){
        object = sprite;
    }

    public Sprite getObject(){
        return object;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        object.draw(batch, parentAlpha);
    }

    @Override
    protected void positionChanged() {
        object.setPosition(getX(),getY());
        super.positionChanged();
    }
}
