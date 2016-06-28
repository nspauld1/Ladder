package com.spaulding.ladder.Levels;

import com.spaulding.ladder.Entities.Floors.Floor;
import com.spaulding.ladder.Entities.Floors.FloorType;
import com.spaulding.ladder.Entities.Ladders.Ladder;
import com.spaulding.ladder.Entities.Ladders.LadderLength;
import com.spaulding.ladder.Entities.Doors.Door;
import com.spaulding.ladder.Entities.Doors.DoorType;
import com.spaulding.ladder.Entities.Items.Item;
import com.spaulding.ladder.Entities.Items.ItemType;

/**
 * Created by jared on 6/6/2016.
 */
public class Level1 extends LevelController implements LevelInterface{
    public static final float WIDTH = 640, HEIGHT = 900;

    public Floor floor1, floor2, floor3, floor4, floor5, floor6;
    public Door door1, door2, door3;
    public Ladder ladder1, ladder2, ladder3;
    public Item item1, item2, item3;

    private static final int KEY_AMOUNT = 3;
    private static final int DOOR_AMOUNT = 3;

    public Level1(){
        super(WIDTH, HEIGHT, KEY_AMOUNT, DOOR_AMOUNT);
        setFloors();
        setLadders();
        setDoors();
        setItems();
        addToArray();
    }

    public void setFloors() {
        floor1 = new Floor(0,0, 360, FloorType.GROUND_LONG);
        floor2 = new Floor(360, 0, 360, FloorType.GROUND_LONG);
        floor3 = new Floor(90,180, 180, FloorType.WOOD_MEDIUM);
        floor4 = new Floor(450, 360, 90, FloorType.WOOD_SMALL);
        floor5 = new Floor(270, 540, 360, FloorType.CONCRETE_LONG);
        floor6 = new Floor(360, 540, 360, FloorType.CONCRETE_LONG);
    }

    public void setLadders() {
        ladder1 = new Ladder(0, 45, 180, LadderLength.TWO);
        ladder2 = new Ladder(540, 45, 360, LadderLength.FOUR);
        ladder3 = new Ladder(180, 225, 360, LadderLength.FOUR);
    }

    public void setDoors() {
        door1 = new Door(555, 585, DoorType.LOCKED);
        door2 = new Door(400, 45, DoorType.LOCKED);
        door3 = new Door(300, 585, DoorType.LOCKED);
    }

    public void setItems() {
        item1 = new Item(505, 450, ItemType.KEY);
        item2 = new Item(0, 45, ItemType.KEY);
        item3 = new Item(45, 270, ItemType.KEY);
    }

    public void addToArray() {
        //floors array for body
        floors.add(floor1.body);
        floors.add(floor2.body);
        floors.add(floor3.body);
        floors.add(floor4.body);
        floors.add(floor5.body);
        floors.add(floor6.body);

        //floors array for updates
        raw_floors.add(floor1);
        raw_floors.add(floor2);
        raw_floors.add(floor3);
        raw_floors.add(floor4);
        raw_floors.add(floor5);
        raw_floors.add(floor6);

        //ladders array for body
        ladders.add(ladder1.body);
        ladders.add(ladder2.body);
        ladders.add(ladder3.body);

        //ladders array for updates
        raw_ladders.add(ladder1);
        raw_ladders.add(ladder2);
        raw_ladders.add(ladder3);

        //doors array for body
        doors.add(door1.body);
        doors.add(door2.body);
        doors.add(door3.body);

        //doors array for updates
        raw_doors.add(door1);
        raw_doors.add(door2);
        raw_doors.add(door3);

        //items array for body
        items.add(item1.body);
        items.add(item2.body);
        items.add(item3.body);

        //items array for updates
        raw_items.add(item1);
        raw_items.add(item2);
        raw_items.add(item3);
    }
}
