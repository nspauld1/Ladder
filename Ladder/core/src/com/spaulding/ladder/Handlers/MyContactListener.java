package com.spaulding.ladder.Handlers;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Entities.Floors.Floor;
import com.spaulding.ladder.Entities.Heros.Hero;
import com.spaulding.ladder.Entities.Ladders.Ladder;
import com.spaulding.ladder.Entities.Doors.Door;
import com.spaulding.ladder.Entities.Doors.DoorType;
import com.spaulding.ladder.Entities.Items.Item;
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

        //hero is touching a ladder
        if (isLadderContact(fa, fb)){
            LevelController.touching_ladder = true;
        }

        //hero is touching ground
        if (isGroundContact(fa, fb)){
            LevelController.touching_ground = true;
        }

        //hero is touching key
        if (isKeyContact(fa, fb)) {
            int i = 0;

            //remove touching body from body array of items
            for (Body body: LevelController.items) {
                if (fb.getBody() == body) {
                    //set that number key pickup to true
                    LevelController.keys[i] = true;
                    body.setUserData(null);

                    //remove raw item from array so not updating unnecessarily
                    for (Item item : LevelController.raw_items) {
                        if (item.body == fb.getBody()) {
                            LevelController.raw_items.remove(item);
                            break;
                        }
                    }
                    break;
                }
                i++;
            }
        }

        //hero is touching door
        if (isDoorContact(fa, fb)) {
            int i = 0;
            for (Door door : LevelController.raw_doors) {
                if (door.body == fb.getBody()) {
                    if (LevelController.keys[i]) {
                        door.dType = DoorType.UNLOCKED;

                        //remove previous body from array
                        LevelController.doors.remove(i);
                        //add new body to array
                        LevelController.doors.add(i, door.body);
                        //set body textures
                        door.body.setUserData(door.sprite);

                        LevelController.touching_door[i] = true;
                        LevelController.door_unlocked[i] = true;
                    }
                }
                i++;
            }
        }
    }

    //called when two fixtures no longer collide
    public void endContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        if (fa == null || fb == null) return;
        if (fa.getUserData() == null || fb.getUserData() == null) return;

        //hero is not touching a ladder
        if (isLadderContact(fa, fb)){
            LevelController.touching_ladder = false;
        }

        //hero is not touching ground
        if (isGroundContact(fa, fb)){
            LevelController.touching_ground = false;
        }

        //hero is not touching key
        if (isKeyContact(fa, fb)) {
        }

        //hero is not touching door
        if (isDoorContact(fa, fb)) {
            for (int i = 0; i < LevelController.touching_door.length; i++) {
                LevelController.touching_door[i] = false;
            }
            int i = 0;
            //when hero is not touching door if key has been picked up keep unlocked texture
            for (Door door : LevelController.raw_doors) {
                if (LevelController.keys[i] && LevelController.door_unlocked[i]) {
                    door.dType = DoorType.UNLOCKED;
                } else {
                    door.dType = DoorType.LOCKED;
                }
                LevelController.doors.remove(i);
                LevelController.doors.add(i, door.body);
                door.body.setUserData(door.sprite);
                i++;
            }
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

    private boolean isKeyContact(Fixture a, Fixture b) {
        if (a.getUserData() instanceof Entity && b.getUserData() instanceof Entity) {
            if (a.getUserData() instanceof Hero && b.getUserData() instanceof Item) {
                return true;
            }
        }
        return false;
    }

    private boolean isDoorContact(Fixture a, Fixture b) {
        if (a.getUserData() instanceof Entity && b.getUserData() instanceof Entity) {
            if (a.getUserData() instanceof Hero && b.getUserData() instanceof Door) {
                return true;
            }
        }
        return false;
    }
}
