package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.spaulding.ladder.Utils.Assets;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/18/2016.
 */
public class AboutScreen extends LadderScreen {
    Main game;
    Vector3 touchpoint;
    OrthographicCamera gui_cam;

    Rectangle goback_bounds;
    private final float BACK_WIDTH = 70, BACK_HEIGHT = 70;
    private final float WIDTH = 640, HEIGHT = 900;

    public AboutScreen(Main game){
        super(game);
        this.game = game;
        touchpoint = new Vector3();
        gui_cam = new OrthographicCamera(WIDTH, HEIGHT);
        gui_cam.position.set(WIDTH / 2, HEIGHT / 2, 0);
        goback_bounds = new Rectangle(5, HEIGHT - 70,BACK_WIDTH, BACK_HEIGHT );
    }

    public void render(float delta){
        update();
        draw();
    }

    public void update(){

        if (Gdx.input.isTouched()){
            gui_cam.unproject(touchpoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (goback_bounds.contains(touchpoint.x, touchpoint.y)) {
                game.setScreen(new MenuScreen(game));
                return;
            }
        }
    }

    public void draw(){
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gui_cam.update();
        game.batcher.setProjectionMatrix(gui_cam.combined);

        game.batcher.begin();
        game.batcher.draw(Assets.back, 5, HEIGHT -70);
        game.batcher.end();
    }
}
