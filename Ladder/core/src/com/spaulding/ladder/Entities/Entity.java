package com.spaulding.ladder.Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.spaulding.ladder.Levels.LevelController;

import static com.spaulding.ladder.Utils.Constants.PPM;

/**
 * Created by jared on 6/5/2016.
 * Superclass Entity creates physics body
 */
public class Entity {
    public final Body body;
    BodyType type;
    public Sprite sprite;
    private FixtureDef fixtureDef;
    private BodyDef def;

    public Entity(float x, float y, float width, float height, BodyType type,
                  boolean canRotate, short cBits, short mBits, String user_date) {
        this.type = type;
        this.body = createBox(x, y, width, height, canRotate, cBits, mBits,
                user_date);
    }

    public Body createBox(float x, float y, float width, float height,
                          boolean canRotate, short cBits, short mBits,
                          String user_data){

        Body pBody;
        def = new BodyDef();
        def.fixedRotation = true;
        def.position.set((x + width / 2) / PPM, (y + height / 2) / PPM);

        switch (type) {
            case DYNAMIC:
                def.type = BodyDef.BodyType.DynamicBody;
                break;
            case STATIC:
                def.type = BodyDef.BodyType.StaticBody;
                break;
            case KINEMATIC:
                def.type = BodyDef.BodyType.KinematicBody;
                break;
        }
        pBody = LevelController.world.createBody(def);


        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);

        fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1.0f;
        fixtureDef.filter.categoryBits = cBits;
        fixtureDef.filter.maskBits = mBits;

        if (user_data == "ladder" ) {
            fixtureDef.isSensor = true;
        }

        pBody.createFixture(fixtureDef).setUserData(this);

        return pBody;
    }
}
