package com.spaulding.ladder.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.spaulding.ladder.Animation;
import com.spaulding.ladder.Assets;
import com.spaulding.ladder.Entities.Floor;
import com.spaulding.ladder.Entities.Ladder;
import com.spaulding.ladder.Entities.Room.Door;
import com.spaulding.ladder.Entities.Entity;
import com.spaulding.ladder.Entities.Room.Items;
import com.spaulding.ladder.Entities.Room.Key;
import com.spaulding.ladder.Main;

import java.util.ArrayList;
import java.util.List;

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

    public final ArrayList<Key> keys;

    Entity floor = new Floor(0,0);

    Key key;

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

//        Entity floor1 = new Floor(Floor.FloorType.GROUND);
//        Entity floor2 = new Floor(Floor.FloorType.GROUND);
//        Entity floor3 = new Floor(Floor.FloorType.WOOD);
//        Entity floor5 = new Floor(Floor.FloorType.WOOD);
//        Entity floor6 = new Floor(Floor.FloorType.WOOD);
//        Entity floor7 = new Floor(Floor.FloorType.WOOD);
//        Entity ladder1 = new Ladder(Ladder.LadderLength.TWO);
//        Entity ladder2 = new Ladder(Ladder.LadderLength.FOUR);
//        Entity ladder3 = new Ladder(Ladder.LadderLength.FOUR);
//        Entity door = new Door(Door.DoorState.LOCKED);
//
//        floor1.setPosition(0,0);
//        floor2.setPosition(floor1.getWidth() + floor1.getX(),0);
//        floor3.setPosition(0,180);
//        floor5.setPosition(floor3.getWidth() + floor3.getX(), 360);
//        floor6.setPosition(0, 540);
//        floor7.setPosition(floor6.getWidth(), 540);
//        ladder1.setPosition(100,floor1.getHeight());
//        ladder2.setPosition(floor3.getWidth() + 100, floor3.getHeight());
//        ladder3.setPosition(0, floor3.getHeight() + floor3.getY());
//        door.setPosition(floor7.getX() + floor7.getWidth() - 165, 540 + floor6.getHeight());
//
//        stage.addActor(floor1);
//        stage.addActor(floor2);
//        stage.addActor(floor3);
//        stage.addActor(floor5);
//        stage.addActor(floor6);
//        stage.addActor(floor7);
//        stage.addActor(ladder1);
//        stage.addActor(ladder2);
//        stage.addActor(ladder3);
//        stage.addActor(door);

        keys = new ArrayList<Key>();
        key = new Key(100,45);
        keys.add(key);

    }

    @Override
    public void render(float delta){
        update();
        draw();
        key.update(delta);
    }

    public void draw(){
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gui_cam.update();
        game.batcher.setProjectionMatrix(gui_cam.combined);

        stage.draw();

        game.batcher.begin();
        game.batcher.draw(Assets.title, (WIDTH / 2) - (TITLE_WIDTH / 2), HEIGHT - 150);
        game.batcher.draw(Assets.play,(WIDTH / 2) - (PLAY_WIDTH / 2),HEIGHT - 300);
        game.batcher.draw(Assets.settings,(WIDTH / 2) - (SETTINGS_WIDTH / 2), HEIGHT - 400);
        game.batcher.draw(Assets.high_score,(WIDTH / 2) - (HIGH_SCORE_WIDTH / 2),HEIGHT - 500);
        game.batcher.draw(Assets.about,(WIDTH / 2) - (ABOUT_WIDTH / 2), HEIGHT - 600);

        game.batcher.draw(Assets.floor_wood, floor.position.x, floor.position.y);

        int len = keys.size();
        for (int i = 0 ; i < len; i++){
            key = keys.get(i);
            TextureRegion keyFrame = Assets.key_anim.getKeyFrame(key.state_time, Animation.ANIMATION_LOOPING);
            game.batcher.draw(keyFrame,key.position.x,key.position.y);
        }
        game.batcher.end();
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
