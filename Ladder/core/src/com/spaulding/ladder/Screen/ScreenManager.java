package com.spaulding.ladder.Screen;

/**
 * Created by jared on 5/14/2016.
 */
public class ScreenManager {

    private static Screen current_screen;

    public static void setScreen(Screen screen){

        if (current_screen != null) {
            current_screen.dispose();
        }

        current_screen = screen;
        current_screen.create();
    }

    public static Screen getCurrentScreen(){
        return current_screen;
    }

}
