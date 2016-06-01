package com.spaulding.ladder;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by jared on 5/18/2016.
 */
public class Assets {
    public static Texture play, settings, high_score, about, back, title, door_unlocked, door_locked,
                            door_opened, floor_concrete, floor_wood, floor_ground, hero;
    public static TextureRegion[] ladders = new TextureRegion[6];
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
        door_opened = new Texture("door_opened.png");
        floor_concrete = new Texture("concrete_floor.png");
        floor_wood = new Texture("wood_floor.png");
        floor_ground = new Texture("ground_floor.png");
        hero = new Texture("hero.png");

        ladder_atlas = new TextureAtlas("ladder_sheet.atlas");
        key_atlas = new TextureAtlas("key_sheet.atlas");

        ladders[0] = new TextureRegion(ladder_atlas.findRegion("ladder_small_small"));
        ladders[1] = new TextureRegion(ladder_atlas.findRegion("ladder_small"));
        ladders[2] = new TextureRegion(ladder_atlas.findRegion("ladder_mediam_mediam"));
        ladders[3] = new TextureRegion(ladder_atlas.findRegion("ladder_mediam"));
        ladders[4] = new TextureRegion(ladder_atlas.findRegion("ladder_large_large"));
        ladders[5] = new TextureRegion(ladder_atlas.findRegion("ladder_large"));

        key_anim = new Animation(.1f, new TextureRegion(key_atlas.findRegion("0001")),
                new TextureRegion(key_atlas.findRegion("0002")),
                new TextureRegion(key_atlas.findRegion("0003")),
                new TextureRegion(key_atlas.findRegion("0004")),
                new TextureRegion(key_atlas.findRegion("0005")),
                new TextureRegion(key_atlas.findRegion("0006")),
                new TextureRegion(key_atlas.findRegion("0007")),
                new TextureRegion(key_atlas.findRegion("0008")),
                new TextureRegion(key_atlas.findRegion("0009")),
                new TextureRegion(key_atlas.findRegion("0010")),
                new TextureRegion(key_atlas.findRegion("0011")),
                new TextureRegion(key_atlas.findRegion("0012")));
    }
}
