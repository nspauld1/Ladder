package com.spaulding.ladder.Levels;

import com.spaulding.ladder.Entities.Floor;
import com.spaulding.ladder.Entities.FloorType;
import com.spaulding.ladder.Entities.Ladder;
import com.spaulding.ladder.Entities.Room.Door;
import com.spaulding.ladder.Entities.Room.Item;

import static com.spaulding.ladder.Utils.Constants.PPM;

/**
 * Created by jared on 6/6/2016.
 */
public class Level1 extends LevelController implements LevelInterface{
    public static final float WIDTH = 2000, HEIGHT = 900;

    public Floor floor1, floor2, floor3, floor4, floor5, floor6;
    public Door door1;
    public Ladder ladder1, ladder2, ladder3;
    public Item item1;

    public Level1(){
        super(WIDTH, HEIGHT);
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
        ladder1 = new Ladder(0, 45, 180,
                Ladder.LadderLength.TWO);
        ladder2 = new Ladder(540, 45, 360,
                Ladder.LadderLength.FOUR);
        ladder3 = new Ladder(180, 225, 360,
                Ladder.LadderLength.FOUR);
    }

    public void setDoors() {

    }

    public void setItems() {

    }

    public void addToArray() {
        //floors array
        floors.add(floor1.body);
        floors.add(floor2.body);
        floors.add(floor3.body);
        floors.add(floor4.body);
        floors.add(floor5.body);
        floors.add(floor6.body);

        //ladders array
        ladders.add(ladder1.body);
        ladders.add(ladder2.body);
        ladders.add(ladder3.body);

        //floors set body texture
        floor1.body.setUserData(floor1.sprite);
        floor2.body.setUserData(floor2.sprite);
        floor3.body.setUserData(floor3.sprite);
        floor4.body.setUserData(floor4.sprite);
        floor5.body.setUserData(floor5.sprite);
        floor6.body.setUserData(floor6.sprite);

        //ladders set body texture
        ladder1.body.setUserData(ladder1.sprite);
        ladder2.body.setUserData(ladder2.sprite);
        ladder3. body.setUserData(ladder3.sprite);
    }
}
