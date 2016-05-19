package com.spaulding.ladder.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.spaulding.ladder.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Ladder";
		config.useGL30 = false;
		config.width = 640;
		config.height = 900;
		new LwjglApplication(new Main(), config);
	}
}
