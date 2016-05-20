package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.spaulding.ladder.Assets;
import com.spaulding.ladder.Entities.Floor;
import com.spaulding.ladder.Entities.Ladder;
import com.spaulding.ladder.Entities.Room.Door;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Main;

/**
 * Created by jared on 5/18/2016.
 */
public class MenuScreen extends LadderScreen {
    Main game;
    Vector3 touchpoint;
    OrthographicCamera gui_cam;
    public Stage stage;

    Rectangle play_bounds, settings_bounds, high_score_bounds, about_bounds;

    private final float PLAY_WIDTH = 100, SETTINGS_WIDTH = 200, HIGH_SCORE_WIDTH = 250,
                        ABOUT_WIDTH = 150, TITLE_WIDTH = 600;
    private final float WIDTH = 640, HEIGHT = 900;

    public MenuScreen(Main game){
        super(game);
        this.game = game;
        touchpoint = new Vector3();
        gui_cam = new OrthographicCamera(WIDTH, HEIGHT);
        gui_cam.position.set(WIDTH / 2, HEIGHT / 2, 0);
        play_bounds = new Rectangle((WIDTH / 2) - (PLAY_WIDTH / 2), HEIGHT - 300, PLAY_WIDTH, 50);
        settings_bounds = new Rectangle((WIDTH / 2) - (SETTINGS_WIDTH / 2), HEIGHT - 400, SETTINGS_WIDTH, 50);
        high_score_bounds = new Rectangle((WIDTH / 2) - (HIGH_SCORE_WIDTH / 2), HEIGHT - 500, HIGH_SCORE_WIDTH, 50);
        about_bounds = new Rectangle((WIDTH / 2) - (ABOUT_WIDTH / 2), HEIGHT - 600, ABOUT_WIDTH, 50);

        stage = new Stage();

        Entity floor1 = new Floor(Floor.FloorType.GROUND);
        Entity floor3 = new Floor(Floor.FloorType.WOOD);
        Entity floor4 = new Floor(Floor.FloorType.WOOD);
        Entity floor5 = new Floor(Floor.FloorType.CONCRETE);
        Entity ladder1 = new Ladder(Ladder.LadderLength.TWO);
        Entity ladder2 = new Ladder(Ladder.LadderLength.FOUR);

        floor1.setPosition(0,0);
        floor3.setPosition(0,180);
        floor4.setPosition(floor3.getWidth() + floor3.getX(), 180);
        floor5.setPosition(floor3.getWidth() + floor3.getX(), 360);
        ladder1.setPosition(100,floor1.getHeight());
        ladder2.setPosition(floor3.getWidth() + 100, floor3.getHeight());

        stage.addActor(floor1);
        stage.addActor(floor3);
        stage.addActor(floor4);
        stage.addActor(floor5);
        stage.addActor(ladder1);
        stage.addActor(ladder2);

    }

    @Override
    public void render(float delta){
        update();
        draw();
    }

    public void draw(){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gui_cam.update();
        game.batcher.setProjectionMatrix(gui_cam.combined);

        game.batcher.begin();
        game.batcher.draw(Assets.title, (WIDTH / 2) - (TITLE_WIDTH / 2), HEIGHT - 150);
        game.batcher.draw(Assets.play,(WIDTH / 2) - (PLAY_WIDTH / 2),HEIGHT - 300);
        game.batcher.draw(Assets.settings,(WIDTH / 2) - (SETTINGS_WIDTH / 2), HEIGHT - 400);
        game.batcher.draw(Assets.high_score,(WIDTH / 2) - (HIGH_SCORE_WIDTH / 2),HEIGHT - 500);
        game.batcher.draw(Assets.about,(WIDTH / 2) - (ABOUT_WIDTH / 2), HEIGHT - 600);
        game.batcher.end();

        stage.draw();
    }

    public void update(){
        if (Gdx.input.isTouched()){
            gui_cam.unproject(touchpoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (play_bounds.contains(touchpoint.x, touchpoint.y)){
                game.setScreen(new GameScreen(game));
                return;
            }
            if (settings_bounds.contains(touchpoint.x, touchpoint.y)){
                game.setScreen(new SettingsScreen(game));
                return;
            }
            if (high_score_bounds.contains(touchpoint.x, touchpoint.y)){
                game.setScreen(new HighScoreScreen(game));
                return;
            }
            if (about_bounds.contains(touchpoint.x, touchpoint.y)){
                game.setScreen(new AboutScreen(game));
                return;
            }
        }
    }


}
