package com.spaulding.ladder.Levels;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.spaulding.ladder.Entities.Enemies.Enemy;
import com.spaulding.ladder.Entities.Floors.Floor;
import com.spaulding.ladder.Entities.Heros.Hero;
import com.spaulding.ladder.Entities.Ladders.Ladder;
import com.spaulding.ladder.Entities.Doors.Door;
import com.spaulding.ladder.Entities.Doors.DoorType;
import com.spaulding.ladder.Entities.Items.Item;
import com.spaulding.ladder.Entities.World.LevelBounds;
import com.spaulding.ladder.Handlers.MyContactListener;
import com.spaulding.ladder.Screens.GameScreen;
import com.spaulding.ladder.Utils.Assets;

import java.util.ArrayList;

import static com.spaulding.ladder.Utils.Constants.PPM;
import static com.spaulding.ladder.Main.WIDTH;
import static com.spaulding.ladder.Main.HEIGHT;

/**
 * Created by jared on 6/6/2016.
 */
public class LevelController {
    private float level_width, level_height;

    private boolean debug = false;

    Application.ApplicationType appType = Gdx.app.getType();

    private OrthographicCamera camera;

    Box2DDebugRenderer b2db;
    public static World world;

    public static Hero hero;

    public static boolean touching_ladder = false;
    public static boolean touching_ground = false;

    SpriteBatch batcher;
    SpriteBatch control_batch;

    public static ArrayList<Body> enemies, heros, floors, ladders, doors, items;

    //create arrays for the actual types for updating
    public static ArrayList<Hero> raw_heros;
    public static ArrayList<Floor> raw_floors;
    public static ArrayList<Ladder> raw_ladders;
    public static ArrayList<Enemy> raw_enemies;
    public static ArrayList<Door> raw_doors;
    public static ArrayList<Item> raw_items;

    //create array for how many and whether or not keys have been picked up
    public static boolean keys[];
    public static boolean touching_door[];
    public static boolean door_unlocked[];

    //input updater variables
    float stillTime = 0;
    public static float MAX_VELOCITY = 9f;
    public static float MAX_CLIMBING_VELOCITY = 3.5f;

    //mobile controls stuff
    Rectangle right_bounds, left_bounds, up_bounds, down_bounds;
    Vector3 touchpoint;

    //Level bounds
    LevelBounds bounds_left, bounds_right, bounds_bottom, bounds_top;


    public LevelController(float level_width, float level_height, int key_amount, int door_amount){
        //screen stuff
        float w = WIDTH;
        float h = HEIGHT;
        this.level_width = level_width;
        this.level_height = level_height;

        //camera stuff
        camera = new OrthographicCamera(w, h);
        camera.position.set(w / 2, h / 2, 0);
        camera.setToOrtho(false, w, h);

        //world stuff
        world = new World(new Vector2(0, -20f), false);
        world.setContactListener(new MyContactListener());
        b2db = new Box2DDebugRenderer();

        //world bounds
        bounds_left = new LevelBounds(0, 0, 1, level_height);
        bounds_right = new LevelBounds(level_width, 0, 1, level_height);
        bounds_top = new LevelBounds(0, level_height, 1, level_width);
        bounds_bottom = new LevelBounds(0, 0, 1, level_width);

        //initialize arrays for bodies
        enemies = new ArrayList<Body>();
        heros = new ArrayList<Body>();
        floors = new ArrayList<Body>();
        ladders = new ArrayList<Body>();
        doors = new ArrayList<Body>();
        items = new ArrayList<Body>();

        //initialize arrays or updates
        raw_heros = new ArrayList<Hero>();
        raw_enemies = new ArrayList<Enemy>();
        raw_floors = new ArrayList<Floor>();
        raw_ladders = new ArrayList<Ladder>();
        raw_doors = new ArrayList<Door>();
        raw_items = new ArrayList<Item>();

        //initialize how many keys are in the world and if they have been picked up
        keys = new boolean[key_amount];
        touching_door = new boolean[door_amount];
        door_unlocked = new boolean[door_amount];

        //create a hero and platform objects with x and y cords
        hero = new Hero(200, 900);

        //convert the sprite size from meters to pixels
        hero.sprite.setSize(hero.HERO_WIDTH / PPM,  hero.HERO_HEIGHT / PPM);

        heros.add(hero.body);

        //set sprite data for body
        hero.body.setUserData(hero.sprite);

        batcher = new SpriteBatch();
        control_batch = new SpriteBatch();

        //Mobile controls set rectangles
        touchpoint = new Vector3();

        left_bounds = new Rectangle(WIDTH - 200, 0, 100, 100);
        right_bounds = new Rectangle(WIDTH - 100, 0, 100, 100);
        up_bounds = new Rectangle(0, 100, 100, 100);
        down_bounds = new Rectangle(0, 0, 100, 100);

    }

    public void render(){
        update(Gdx.graphics.getDeltaTime());
        //Render
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //start renders
        batcher.begin();
        drawFloors();
        drawLadders();
        drawDoors();
        drawItems();
        drawHero();
        batcher.end();

        //if ran on android display onscreen controls
        if (appType == Application.ApplicationType.Android) {
            control_batch.begin();
            Color c = control_batch.getColor();
            control_batch.setColor(c.r, c.g, c.b, .5f);
            control_batch.draw(Assets.arrow_right, Gdx.graphics.getWidth() - 200, 0);
            control_batch.draw(Assets.arrow_left, Gdx.graphics.getWidth() - 400, 0);
            control_batch.draw(Assets.arrow_up, 0, 200);
            control_batch.draw(Assets.arrow_down, 0, 0);
            control_batch.end();
        }

        if (debug) {
            b2db.render(world, camera.combined.scl(PPM));
            batcher.setProjectionMatrix(camera.combined);
        } else {
            batcher.setProjectionMatrix(camera.combined.scl(PPM));
        }
    }

    private void drawHero(){
        for (Body body : heros){
            if (body.getUserData() instanceof Sprite){
                Sprite sprite = ((Sprite) body.getUserData());
                sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
                sprite.setOriginCenter();
                sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
                sprite.draw(batcher);
            }
        }
    }

    private void drawFloors(){
        for (Body body : floors){
            if (body.getUserData() instanceof Sprite){
                Sprite sprite = ((Sprite) body.getUserData());
                sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
                sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
                sprite.draw(batcher);
            }
        }
    }

    private void drawLadders(){
        for (Body body : ladders){
            if (body.getUserData() instanceof Sprite){
                Sprite sprite = ((Sprite) body.getUserData());
                sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
                sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
                sprite.draw(batcher);
            }
        }
    }

    private void drawDoors(){
        for (Body body : doors){
            if (body.getUserData() instanceof Sprite){
                Sprite sprite = ((Sprite) body.getUserData());
                sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
                sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
                sprite.draw(batcher);
            }
        }
    }

    private void drawItems(){
        for (Body body : items ){
            if (body.getUserData() instanceof Sprite) {
                Sprite sprite = ((Sprite) body.getUserData());
                sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
                sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
                sprite.draw(batcher);
            }
        }
    }

    public void update(float delta) {
        //updates the world
        world.step(1 / 60f, 6, 2);

        inputUpdate(delta);
        cameraUpdate(delta);

        updateHeros(delta);
        updateEnemies(delta);
        updateFloors(delta);
        updateLadders(delta);
        updateDoors(delta);
        updateItems(delta);

    }

    private void updateHeros(float delta){
        for (Hero hero : raw_heros) {
            hero.update(delta);
        }
    }

    private void updateEnemies(float delta){
        for (Enemy enemy : raw_enemies) {
            enemy.update(delta);
        }
    }

    private void updateFloors(float delta){
        for (Floor floor : raw_floors) {
            switch (floor.fType) {
                case CONCRETE_SMALL:
                    floor.sprite = new Sprite(Assets.floors[0]);
                    break;
                case CONCRETE_MEDIUM:
                    floor.sprite = new Sprite(Assets.floors[1]);
                    break;
                case CONCRETE_LONG:
                    floor.sprite = new Sprite(Assets.floors[2]);
                    break;
                case WOOD_SMALL:
                    floor.sprite = new Sprite(Assets.floors[3]);
                    break;
                case WOOD_MEDIUM:
                    floor.sprite = new Sprite(Assets.floors[4]);
                    break;
                case WOOD_LONG:
                    floor.sprite = new Sprite(Assets.floors[5]);
                    break;
                case GROUND_SMALL:
                    floor.sprite = new Sprite(Assets.floors[6]);
                    break;
                case GROUND_MEDIUM:
                    floor.sprite = new Sprite(Assets.floors[7]);
                    break;
                case GROUND_LONG:
                    floor.sprite = new Sprite(Assets.floors[8]);
                    break;
            }
            floor.defineSprite(floor.sprite);
            floor.body.setUserData(floor.sprite);
            floor.update(delta);
        }
    }

    private void updateLadders(float delta){
        for (Ladder ladder : raw_ladders) {
            switch (ladder.length) {
                case ONE:
                    ladder.sprite = new Sprite(Assets.ladders[0]);
                    break;
                case TWO:
                    ladder.sprite = new Sprite(Assets.ladders[1]);
                    break;
                case THREE:
                    ladder.sprite = new Sprite(Assets.ladders[2]);
                    break;
                case FOUR:
                    ladder.sprite = new Sprite(Assets.ladders[3]);
                    break;
                case FIVE:
                    ladder.sprite = new Sprite(Assets.ladders[4]);
                    break;
                case SIX:
                    ladder.sprite = new Sprite(Assets.ladders[5]);
                    break;
            }
            ladder.defineSprite(ladder.sprite);
            ladder.body.setUserData(ladder.sprite);
            ladder.update(delta);
        }
    }

    private void updateDoors(float delta){
        for (Door door : raw_doors) {
            switch (door.dType) {
                case UNLOCKED:
                    door.sprite = new Sprite(Assets.door_unlocked);
                    break;
                case LOCKED:
                    door.sprite = new Sprite(Assets.door_locked);
                    break;
                case OPENED:
                    door.sprite = new Sprite(Assets.door_opened);
                    break;
            }
            door.defineSprite(door.sprite);
            door.body.setUserData(door.sprite);
            door.update(delta);
        }
    }

    private void updateItems(float delta){
        for (Item item : raw_items){
            item.body.setUserData(item.sprite);
            item.update(delta, item.iType);
        }
    }

    /*
    input delta time
    decision making code for hero movement
     */
    public void inputUpdate(float delta){
        Vector2 vel = hero.body.getLinearVelocity();
        Vector2 pos = hero.body.getPosition();

        if (appType == Application.ApplicationType.Android){
            androidInput(vel, pos);
        }
        if (appType == Application.ApplicationType.Desktop) {
            desktopInput(vel, pos);
        }
    }

    public void androidInput(Vector2 vel, Vector2 pos){
        if (Gdx.input.isTouched()) {
            camera.unproject(touchpoint.set(Gdx.input.getX(),Gdx.input.getY(),0));

            // cap max velocity on x
            if(Math.abs(vel.x) > MAX_VELOCITY) {
                vel.x = Math.signum(vel.x) * MAX_VELOCITY;
                hero.body.setLinearVelocity(vel.x, vel.y);
            }

            // calculate stilltime & damp
            if(!left_bounds.contains(touchpoint.x,touchpoint.y) &&
                    !right_bounds.contains(touchpoint.x,touchpoint.y)) {

            }
            else {
                stillTime = 0;
            }

            //apply vertical impulse only if ladder is being touched
            if (up_bounds.contains(touchpoint.x,touchpoint.y) && touching_ladder && vel.y < MAX_CLIMBING_VELOCITY){
                hero.body.applyLinearImpulse(0, 15, pos.x, pos.y, true);
            }

            // apply left impulse, but only if max velocity is not reached yet
            if(left_bounds.contains(touchpoint.x, touchpoint.y) && vel.x > -MAX_VELOCITY) {
                if (touching_ground) {
                    hero.body.applyLinearImpulse(-4f, 0, pos.x, pos.y, true);
                } else {
                    hero.body.applyLinearImpulse(-2f, 0, pos.x, pos.y, true);
                }
            }

            // apply right impulse, but only if max velocity is not reached yet
            if(right_bounds.contains(touchpoint.x,touchpoint.y) && vel.x < MAX_VELOCITY) {
                if (touching_ground) {
                    hero.body.applyLinearImpulse(4f, 0, pos.x, pos.y, true);
                } else {
                    hero.body.applyLinearImpulse(2f, 0, pos.x, pos.y, true);
                }
            }
        } else {
            stillTime += Gdx.graphics.getDeltaTime();
            hero.body.setLinearVelocity(vel.x * 0.8f, vel.y);
            System.out.println("here");
        }
    }

    public void desktopInput(Vector2 vel, Vector2 pos){
        // cap max velocity on x
        if(Math.abs(vel.x) > MAX_VELOCITY) {
            vel.x = Math.signum(vel.x) * MAX_VELOCITY;
            hero.body.setLinearVelocity(vel.x, vel.y);
        }

        // calculate stilltime & damp
        if(!Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.D)) {
            stillTime += Gdx.graphics.getDeltaTime();
            hero.body.setLinearVelocity(vel.x * 0.8f, vel.y);
        }
        else {
            stillTime = 0;
        }

        //apply vertical impulse only if ladder is being touched
        if (Gdx.input.isKeyPressed(Input.Keys.W) && touching_ladder && vel.y < MAX_CLIMBING_VELOCITY){
            hero.body.applyLinearImpulse(0, 15, pos.x, pos.y, true);
        }

        // apply left impulse, but only if max velocity is not reached yet
        if(Gdx.input.isKeyPressed(Input.Keys.A) && vel.x > -MAX_VELOCITY) {
            if (touching_ground) {
                hero.body.applyLinearImpulse(-4f, 0, pos.x, pos.y, true);
            } else {
                hero.body.applyLinearImpulse(-2f, 0, pos.x, pos.y, true);
            }
        }

        // apply right impulse, but only if max velocity is not reached yet
        if(Gdx.input.isKeyPressed(Input.Keys.D) && vel.x < MAX_VELOCITY) {
            if (touching_ground) {
                hero.body.applyLinearImpulse(4f, 0, pos.x, pos.y, true);
            } else {
                hero.body.applyLinearImpulse(2f, 0, pos.x, pos.y, true);
            }
        }

        //pause menu
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            GameScreen.state = GameScreen.GameState.GAME_STATE_PAUSE;
        }

        //toggle debug mode
        if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
            if (debug) {
                debug = false;
            } else {
                debug = true;
            }
        }

        //toggle door open
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            int i = 0;
            for (Door door : raw_doors) {
                if (touching_door[i]) {
                    door.dType = DoorType.OPENED;
                    doors.remove(i);
                    doors.add(i, door.body);
                    door.body.setUserData(door.sprite);
                }
                i++;
            }
        }
    }

    /*
    camera follows the hero within level boundaries
     */
    public void cameraUpdate(float delta){
        // The left boundary of the map (x)
        float mapLeft = 0;
        // The right boundary of the map (x + width)
        float mapRight = 0 + level_width;
        // The bottom boundary of the map (y)
        float mapBottom = 0;
        // The top boundary of the map (y + height)
        float mapTop = 0 + level_height;
        // The camera dimensions, halved
        float cameraHalfWidth = camera.viewportWidth * .5f;
        float cameraHalfHeight = camera.viewportHeight * .5f;

        // Move camera after player as normal

        camera.position.y = hero.body.getPosition().y * PPM;
        camera.position.x = hero.body.getPosition().x * PPM;

        float cameraLeft = camera.position.x - cameraHalfWidth;
        float cameraRight = camera.position.x + cameraHalfWidth;
        float cameraBottom = camera.position.y - cameraHalfHeight;
        float cameraTop = camera.position.y + cameraHalfHeight;

        // Horizontal axis
        if(level_width < camera.viewportWidth)
        {
            camera.position.x = mapRight / 2;
        }
        else if(cameraLeft <= mapLeft)
        {
            camera.position.x = mapLeft + cameraHalfWidth;
        }
        else if(cameraRight >= mapRight)
        {
            camera.position.x = mapRight - cameraHalfWidth;
        }

        // Vertical axis
        if(level_height < camera.viewportHeight)
        {
            camera.position.y = mapTop / 2;
        }
        else if(cameraBottom <= mapBottom)
        {
            camera.position.y = mapBottom + cameraHalfHeight;
        }
        else if(cameraTop >= mapTop)
        {
            camera.position.y = mapTop - cameraHalfHeight;
        }

        camera.update();
    }
}
