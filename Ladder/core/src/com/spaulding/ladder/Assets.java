package com.spaulding.ladder;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by jared on 5/18/2016.
 */
public class Assets {
    public static Texture play, settings, high_score, about, back, title;

    public static void load(){
        play = new Texture("play.png");
        settings = new Texture("settings.png");
        high_score = new Texture("high_score.png");
        about = new Texture("about.png");
        title = new Texture("title.png");
        back = new Texture("back.png");
    }
}
