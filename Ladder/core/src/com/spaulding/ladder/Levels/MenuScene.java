package com.spaulding.ladder.Levels;

import com.spaulding.ladder.Entities.Floor;
import com.spaulding.ladder.Entities.Ladder;
import com.spaulding.ladder.Entities.Room.Door;
import com.spaulding.ladder.Entities.Room.Key;

import java.util.ArrayList;

/**
 * Created by jared on 5/25/2016.
 */
public class MenuScene {
    public Floor floor1, floor2, floor3, floor4, floor5, floor6;
    public Door door1;
    public Ladder ladder1, ladder2, ladder3;
    public Key key1;

    public final ArrayList<Key> keys;

    public MenuScene(){
        floor1 = new Floor(0,0, Floor.FloorType.GROUND);
        floor2 = new Floor(floor1.bounds.width + floor1.position.x, 0,
                Floor.FloorType.GROUND);
        floor3 = new Floor(0,180, Floor.FloorType.WOOD);
        floor4 = new Floor(floor3.bounds.width + floor3.position.x, 360,
                Floor.FloorType.WOOD);
        floor5 = new Floor(0, 540, Floor.FloorType.WOOD);
        floor6 = new Floor(floor5.bounds.width + floor5.position.x, 540,
                Floor.FloorType.WOOD);

        ladder1 = new Ladder(100, floor1.bounds.height, 180,
                Ladder.LadderLength.ONE);
        ladder2 = new Ladder(floor3.bounds.width + 100, floor3.bounds.height, 270,
                Ladder.LadderLength.FOUR);
        ladder3 = new Ladder(0, floor3.bounds.height + floor3.position.y, 315,
                Ladder.LadderLength.FOUR);

        door1 = new Door(floor6.position.x + floor6.bounds.width - 165, 540 + floor5.bounds.height,
                Door.DoorType.LOCKED);

        key1 = new Key(floor4.position.x + 100, floor3.bounds.height + 360);

        keys = new ArrayList<Key>();
        keys.add(key1);
    }
}
