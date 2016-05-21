package com.spaulding.ladder;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by jared on 5/21/2016.
 */
public class Animation {
    public static final int ANIMATION_LOOPING = 0;
    public static final int ANIMATION_NONLOOPING = 1;

    final TextureRegion[] keyframes;
    final float frame_duration;

    public Animation (float frame_duration, TextureRegion... keyframes){
        this.frame_duration = frame_duration;
        this.keyframes = keyframes;
    }

    public TextureRegion getKeyFrame (float state_time, int mode){
        int frame_number = (int)(state_time / frame_duration);

        if (mode == ANIMATION_NONLOOPING){
            frame_number = Math.min(keyframes.length - 1, frame_number);
        } else {
            frame_number = frame_number % keyframes.length;
        }
        return keyframes[frame_number];
    }
}
