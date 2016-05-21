package com.spaulding.ladder;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by jared on 5/18/2016.
 */
public class Assets {
    public static Texture play, settings, high_score, about, back, title, door_unlocked, door_locked,
                            floor_concrete, floor_wood, floor_ground;
    public static TextureRegion[] ladders = new TextureRegion[6];
    public static TextureRegion[] keys = new TextureRegion[9];
    public static TextureAtlas ladder_atlas, key_atlas;

    public static Animation key_anim;

    public static void load(){
        play = new Texture("play.png");
        settings = new Texture("settings.png");
        high_score = new Texture("high_score.png");
        about = new Texture("about.png");
        title = new Texture("title.png");
        back = new Texture("back.png");
        door_unlocked = new Texture("unlocked_door.png");
        door_locked = new Texture("locked_door.png");
        floor_concrete = new Texture("concrete_floor.png");
        floor_wood = new Texture("wood_floor.png");
        floor_ground = new Texture("ground_floor.png");

        ladder_atlas = new TextureAtlas("ladder_sheet.atlas");
        key_atlas = new TextureAtlas("key_sheet.atlas");

        ladders[0] = new TextureRegion(ladder_atlas.findRegion("ladder_small_small"));
        ladders[1] = new TextureRegion(ladder_atlas.findRegion("ladder_small"));
        ladders[2] = new TextureRegion(ladder_atlas.findRegion("ladder_mediam_mediam"));
        ladders[3] = new TextureRegion(ladder_atlas.findRegion("ladder_mediam"));
        ladders[4] = new TextureRegion(ladder_atlas.findRegion("ladder_large_large"));
        ladders[5] = new TextureRegion(ladder_atlas.findRegion("ladder_large"));

        keys[0] = new TextureRegion(key_atlas.findRegion("key1"));
        keys[1] = new TextureRegion(key_atlas.findRegion("key2"));
        keys[2] = new TextureRegion(key_atlas.findRegion("key3"));
        keys[3] = new TextureRegion(key_atlas.findRegion("key4"));
        keys[4] = new TextureRegion(key_atlas.findRegion("key5"));
        keys[5] = new TextureRegion(key_atlas.findRegion("key6"));
        keys[6] = new TextureRegion(key_atlas.findRegion("key7"));
        keys[7] = new TextureRegion(key_atlas.findRegion("key8"));
        keys[8] = new TextureRegion(key_atlas.findRegion("key9"));

        key_anim = new Animation(.2f, new TextureRegion(key_atlas.findRegion("key1")),
                new TextureRegion(key_atlas.findRegion("key2")));
    }
}
