package com.spaulding.ladder.Utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.spaulding.ladder.Animation;

/**
 * Created by jared on 5/18/2016.
 */
public class Assets {
    public static Texture play, settings, high_score, about, back, title, door_unlocked, door_locked,
                            door_opened, hero,
                            arrow_right, arrow_left, arrow_up, arrow_down;
    public static TextureRegion[] ladders = new TextureRegion[6];
    public static TextureRegion[] floors = new TextureRegion[9];

    public static TextureAtlas ladder_atlas, key_atlas, floor_atlas;

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

        hero = new Texture("hero.png");

        arrow_right = new Texture("arrow_right.png");
        arrow_left = new Texture("arrow_left.png");
        arrow_up = new Texture("arrow_up.png");
        arrow_down = new Texture("arrow_down.png");

        ladder_atlas = new TextureAtlas("ladder_sheet.atlas");
        key_atlas = new TextureAtlas("key_sheet.atlas");
        floor_atlas = new TextureAtlas("floor_sheet.atlas");

        ladders[0] = new TextureRegion(ladder_atlas.findRegion("ladder_small_small"));
        ladders[1] = new TextureRegion(ladder_atlas.findRegion("ladder_small"));
        ladders[2] = new TextureRegion(ladder_atlas.findRegion("ladder_mediam_mediam"));
        ladders[3] = new TextureRegion(ladder_atlas.findRegion("ladder_mediam"));
        ladders[4] = new TextureRegion(ladder_atlas.findRegion("ladder_large_large"));
        ladders[5] = new TextureRegion(ladder_atlas.findRegion("ladder_large"));

        floors[0] = new TextureRegion(floor_atlas.findRegion("floor_concrete_small"));
        floors[1] = new TextureRegion(floor_atlas.findRegion("floor_concrete_medium"));
        floors[2] = new TextureRegion(floor_atlas.findRegion("floor_concrete_long"));
        floors[3] = new TextureRegion(floor_atlas.findRegion("floor_wood_small"));
        floors[4] = new TextureRegion(floor_atlas.findRegion("floor_wood_medium"));
        floors[5] = new TextureRegion(floor_atlas.findRegion("floor_wood_long"));
        floors[6] = new TextureRegion(floor_atlas.findRegion("floor_ground_small"));
        floors[7] = new TextureRegion(floor_atlas.findRegion("floor_ground_medium"));
        floors[8] = new TextureRegion(floor_atlas.findRegion("floor_ground_long"));

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
