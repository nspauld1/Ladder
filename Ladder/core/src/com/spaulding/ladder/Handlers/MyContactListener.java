package com.spaulding.ladder.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Entities.Floor;
import com.spaulding.ladder.Entities.Hero;
import com.spaulding.ladder.Entities.Ladder;
import com.spaulding.ladder.Levels.LevelController;

/**
 * Created by jared on 6/8/2016.
 */
public class MyContactListener implements ContactListener {

    //called when to fixtures begin to collide
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if (fa == null || fb == null) return;
        if (fa.getUserData() == null || fb.getUserData() == null) return;

        if (isLadderContact(fa, fb)){
            System.out.println("hero is touching ladder");
            LevelController.touching_ladder = true;
        }

        if (!isGroundContact(fa, fb)){
            LevelController.touching_ground = false;
            System.out.println("hero is not touching ground");
        }
    }

    //called when two fixtures no longer collide
    public void endContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if (fa == null || fb == null) return;
        if (fa.getUserData() == null || fb.getUserData() == null) return;

        if (isLadderContact(fa, fb)){
            System.out.println("hero is not touching ladder");
            LevelController.touching_ladder = false;
        }

        if (!isGroundContact(fa, fb)){
            LevelController.touching_ground = true;
            System.out.println("hero is touching ground");
        }

    }

    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    private boolean isLadderContact(Fixture a, Fixture b){
        if (a.getUserData() instanceof Entity && b.getUserData() instanceof  Entity){
            if (a.getUserData() instanceof Hero && b.getUserData() instanceof Ladder){
                return true;
            }
        }
        return false;
    }

    private boolean isGroundContact(Fixture a, Fixture b){
        if (a.getUserData() instanceof Entity && b.getUserData() instanceof Entity){
            if(a.getUserData() instanceof Hero && b.getUserData() instanceof Floor){
                return true;
            }
        }
        return false;
    }
}
