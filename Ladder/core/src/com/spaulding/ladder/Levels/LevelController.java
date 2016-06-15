package com.spaulding.ladder.Levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.spaulding.ladder.Entities.Hero;
import com.spaulding.ladder.Handlers.MyContactListener;

import java.util.ArrayList;

import static com.spaulding.ladder.Utils.Constants.PPM;

/**
 * Created by jared on 6/6/2016.
 */
public class LevelController {
    private float level_width, level_height;

    private boolean debug = false;

    private OrthographicCamera camera;

    Box2DDebugRenderer b2db;
    public static World world;

    public static Hero hero;

    public static boolean touching_ladder = false;
    public static boolean touching_ground = false;

    SpriteBatch batcher;

    public ArrayList<Body> enemies, heros, floors, ladders, doors, items;

    public LevelController(float level_width, float level_height){
        //screen stuff
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        this.level_width = level_width;
        this.level_height = level_height;

        //camera stuff
        camera = new OrthographicCamera(w, h);
        camera.position.set(w / 2, h / 2, 0);
        camera.setToOrtho(false, w, h);

        //world stuff
        world = new World(new Vector2(0, -9.8f), false);
        world.setContactListener(new MyContactListener());
        b2db = new Box2DDebugRenderer();

        //initialize arrays
        enemies = new ArrayList<Body>();
        heros = new ArrayList<Body>();
        floors = new ArrayList<Body>();
        ladders = new ArrayList<Body>();
        doors = new ArrayList<Body>();
        items = new ArrayList<Body>();


        //create a hero and platform objects with x and y cords
        hero = new Hero(200, 900);

        //convert the sprite size from meters to pixels
        hero.sprite.setSize(hero.HERO_WIDTH / PPM,  hero.HERO_HEIGHT / PPM);

        heros.add(hero.body);

        //set sprite data for body
        hero.body.setUserData(hero.sprite);

        batcher = new SpriteBatch();
    }

    public void render(){
        update(Gdx.graphics.getDeltaTime());

        //Render
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        b2db.render(world, camera.combined.scl(PPM));
        batcher.setProjectionMatrix(camera.combined);

        batcher.begin();
		/*
		loop that iterates through bodies array
		then prints the sprite to the screen according to bodies pos and rotation
		 */
        drawFloors();
        drawLadders();
        drawHero();
        batcher.end();
    }

    private void drawHero(){
        for (Body body : heros){
            if (body.getUserData() instanceof Sprite){
                Sprite sprite = ((Sprite) body.getUserData());
                sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
                //sprite.setRotation();
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

    }

    private void drawItems(){

    }

    public void update(float delta) {
        //updates the world
        world.step(1 / 60f, 6, 2);

        inputUpdate(delta);
        cameraUpdate(delta);
    }

    /*
    input delta time
    decision making code for hero movement
     */
    public void inputUpdate(float delta){
        int horizontal_force = 0;
        float vertical_force = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            horizontal_force = -1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            horizontal_force = 1;
        }
        if (touching_ladder == true) {
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                vertical_force = 1;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                vertical_force = -.5f;
            }
        }
        hero.body.setLinearVelocity(horizontal_force * 10, world.getGravity().y + vertical_force * 15);
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
