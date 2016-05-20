package com.spaulding.ladder.Entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by jared on 5/19/2016.
 */
public class Entity extends Actor {
    private Sprite entity;

    public Sprite getEntity() {
        return entity;
    }

    public void setEntity(Sprite entity) {
        this.entity = entity;
    }

    @Override
    public float getWidth(){
        return getEntity().getWidth();
    }

    @Override
    public float getHeight(){
        return getEntity().getHeight();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        entity.draw(batch);
    }

    @Override
    protected void positionChanged() {
        entity.setPosition(getX(), getY());
        super.positionChanged();
    }
}
