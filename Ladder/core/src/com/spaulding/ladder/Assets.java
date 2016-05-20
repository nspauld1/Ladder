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
    public static TextureAtlas ladder_atlas;

    public static void load(){
        play = new Texture("play.png");
        settings = new Texture("settings.png");
        high_score = new Texture("high_score.png");
        about = new Texture("about.png");
        title = new Texture("title.png");
        back = new Texture("back.png");
        ladder_atlas = new TextureAtlas("ladder_sheet.atlas");
        door_unlocked = new Texture("unlocked_door.png");
        door_locked = new Texture("locked_door.png");
        floor_concrete = new Texture("concrete_floor.png");
        floor_wood = new Texture("wood_floor.png");
        floor_ground = new Texture("ground_floor.png");


        ladders[0] = new TextureRegion(ladder_atlas.findRegion("ladder_small_small"));
        ladders[1] = new TextureRegion(ladder_atlas.findRegion("ladder_small"));
        ladders[2] = new TextureRegion(ladder_atlas.findRegion("ladder_mediam_mediam"));
        ladders[3] = new TextureRegion(ladder_atlas.findRegion("ladder_mediam"));
        ladders[4] = new TextureRegion(ladder_atlas.findRegion("ladder_large_large"));
        ladders[5] = new TextureRegion(ladder_atlas.findRegion("ladder_large"));
    }
}
