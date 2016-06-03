package com.spaulding.ladder.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.spaulding.ladder.Animation;
import com.spaulding.ladder.Assets;
import com.spaulding.ladder.Entities.Floor;
import com.spaulding.ladder.Entities.Hero;
import com.spaulding.ladder.Entities.Ladder;
import com.spaulding.ladder.Entities.Room.Door;
import com.spaulding.ladder.Entities.Room.Item;
import com.spaulding.ladder.Screens.GameScreen;

import java.util.ArrayList;

/**
 * Created by jared on 5/27/2016.
 */
public class LevelController {
    SpriteBatch batcher;
    OrthographicCamera camera;

    public final ArrayList<Item> items;
    public final ArrayList<Ladder> ladders;
    public final ArrayList<Floor> floors;
    public final ArrayList<Door> doors;
    public final boolean[] keys;

    private float delta = Gdx.graphics.getDeltaTime();

    public static Hero hero;

    float counter = 0;

    public LevelController(float WIDTH, float HEIGHT, int key_amount){
        batcher = new SpriteBatch();
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        camera.position.set(WIDTH / 2, HEIGHT / 2, 0);

        hero = new Hero(320, 45);

        items = new ArrayList<Item>();
        ladders = new ArrayList<Ladder>();
        floors = new ArrayList<Floor>();
        doors = new ArrayList<Door>();

        keys = new boolean[key_amount];
        keys[0] = false;
    }

    public Hero getHero(){
        return hero;
    }

    public void draw(){
        Gdx.gl.glClearColor(0f,0f,0f,0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batcher.begin();
        drawFloors();
        drawLadders();
        drawDoors();
        drawItems();
        drawHero();
        batcher.end();
    }

    public void checkCollisions(){
        checkFloorCollision();
        checkLadderCollision();
        checkDoorCollision();
        checkItemCollision();
    }

    public void drawFloors(){
        for (Floor floor : floors){
            switch (floor.type){
                case GROUND:
                    batcher.draw(Assets.floor_ground,floor.position.x,floor.position.y);
                    break;
                case WOOD:
                    batcher.draw(Assets.floor_wood,floor.position.x,floor.position.y);
                    break;
                case CONCRETE:
                    batcher.draw(Assets.floor_concrete,floor.position.x,floor.position.y);
                    break;
            }
        }
    }

    public void drawLadders(){
        for (Ladder ladder : ladders){
            switch (ladder.length){
                case ONE:
                    batcher.draw(Assets.ladders[0], ladder.position.x, ladder.position.y);
                    break;
                case TWO:
                    batcher.draw(Assets.ladders[1], ladder.position.x, ladder.position.y);
                    break;
                case THREE:
                    batcher.draw(Assets.ladders[2], ladder.position.x, ladder.position.y);
                    break;
                case FOUR:
                    batcher.draw(Assets.ladders[3], ladder.position.x, ladder.position.y);
                    break;
                case FIVE:
                    batcher.draw(Assets.ladders[4], ladder.position.x, ladder.position.y);
                    break;
                case SIX:
                    batcher.draw(Assets.ladders[5], ladder.position.x, ladder.position.y);
                    break;
            }
        }
    }

    public void drawDoors(){
        for (Door door : doors){
            switch (door.type){
                case LOCKED:
                    batcher.draw(Assets.door_locked, door.position.x, door.position.y);
                    break;
                case UNLOCKED:
                    batcher.draw(Assets.door_unlocked, door.position.x, door.position.y);
                    break;
                case OPEN:
                    batcher.draw(Assets.door_opened, door.position.x, door.position.y);
            }
        }
    }

    public void drawItems(){
        for (Item item : items){
            switch (item.type) {
                case KEY:
                    item.update(delta);
                    TextureRegion key_frame = Assets.key_anim.getKeyFrame(item.state_time,
                            Animation.ANIMATION_LOOPING);
                    batcher.draw(key_frame, item.position.x, item.position.y);
                    break;
            }
        }
    }

    public void drawHero(){
        batcher.draw(Assets.hero, hero.position.x, hero.position.y);
    }

    public void checkLadderCollision(){
        for (Ladder ladder : ladders){
            if (hero.bounds.overlaps(ladder.bounds)){
                hero.state = Hero.HeroState.HERO_STATE_CLIMB;
                break;
            }
        }
    }

    public void checkFloorCollision(){
        for (Floor floor : floors){
            if (!hero.bounds.overlaps(floor.bounds)){
                hero.state = Hero.HeroState.HERO_STATE_FALL;
            }
            else {
                hero.state = Hero.HeroState.HERO_STATE_COLLIDE;
                break;
            }
        }
    }

    public void checkDoorCollision(){
        for (int i = 0; i < doors.size(); i++){
            Door door = doors.get(i);
            if (hero.bounds.overlaps(door.bounds)){
                hero.state = Hero.HeroState.HERO_STATE_COLLIDE;
                if (keys[i]){
                    doors.get(i).type = Door.DoorType.UNLOCKED;
                }

                if (Gdx.input.isKeyPressed(Input.Keys.UP)){
                    doors.get(i).type = Door.DoorType.OPEN;
                }

                if (doors.get(doors.size() - 1).type == Door.DoorType.OPEN){
                    endAnimation();
                }

                break;
            }
        }
    }

    public void checkItemCollision(){
        for (int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            if (hero.bounds.overlaps(item.bounds)){
                hero.state = Hero.HeroState.HERO_STATE_COLLECT;
                items.remove(item);
                keys[i] = true;
                break;
            }
        }
    }

    public void update(){
        hero.update(delta);
    }

    private void endAnimation(){
        float delta = Gdx.graphics.getDeltaTime();
        counter += delta * 100;
        System.out.println(counter);
        if (counter >= 5){
            GameScreen.state = GameScreen.GameState.GAME_STATE_WIN;
        }
    }
}
