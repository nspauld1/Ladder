package com.spaulding.ladder.Levels;

import com.badlogic.gdx.math.Vector2;
import com.spaulding.ladder.Entities.Floor;
import com.spaulding.ladder.Entities.Ladder;
import com.spaulding.ladder.Entities.Room.Door;
import com.spaulding.ladder.Entities.Room.Item;
/**
 * Created by jared on 5/19/2016.
 */
public class Level1 extends Level implements LevelInterface{

    public static final Vector2 gravity = new Vector2(0, -12f);
    public static final float WIDTH = 640, HEIGHT = 900;

    public Floor floor1, floor2, floor3, floor4, floor5, floor6;
    public Door door1;
    public Ladder ladder1, ladder2, ladder3;
    public Item item1;

    public static boolean key1_pickup = false;

    public Level1(){
        super(WIDTH,HEIGHT, 1);
        setFloors();
        setLadders();
        setDoors();
        setItems();
        addToArray();
    }

    public void setFloors(){
        floor1 = new Floor(0,0,
                Floor.FloorType.GROUND);
        floor2 = new Floor(floor1.bounds.width + floor1.position.x, 0,
                Floor.FloorType.GROUND);
        floor3 = new Floor(0,180,
                Floor.FloorType.WOOD);
        floor4 = new Floor(floor3.bounds.width + floor3.position.x, 360,
                Floor.FloorType.WOOD);
        floor5 = new Floor(0, 540,
                Floor.FloorType.CONCRETE);
        floor6 = new Floor(floor5.bounds.width + floor5.position.x, 540,
                Floor.FloorType.CONCRETE);
    }

    public void setLadders(){
        ladder1 = new Ladder(100, floor1.bounds.height, 180,
                Ladder.LadderLength.TWO);
        ladder2 = new Ladder(floor3.bounds.width + 100, floor3.bounds.height, 360,
                Ladder.LadderLength.FOUR);
        ladder3 = new Ladder(0, floor3.bounds.height + floor3.position.y, 360,
                Ladder.LadderLength.FOUR);
    }

    public void setDoors(){
        door1 = new Door(floor6.position.x + floor6.bounds.width - 165, 540 + floor5.bounds.height,
                Door.DoorType.LOCKED);
    }

    public void setItems(){
        item1 = new Item(floor4.position.x + 100, floor3.bounds.height + 360,
                Item.ItemType.KEY);
    }

    public void addToArray(){
        items.add(item1);

        floors.add(floor1);
        floors.add(floor2);
        floors.add(floor3);
        floors.add(floor4);
        floors.add(floor5);
        floors.add(floor6);

        ladders.add(ladder1);
        ladders.add(ladder2);
        ladders.add(ladder3);

        doors.add(door1);

        keys[0] = key1_pickup;
    }
}
