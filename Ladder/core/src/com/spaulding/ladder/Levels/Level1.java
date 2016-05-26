package com.spaulding.ladder.Levels;

import com.spaulding.ladder.Entities.Floor;
import com.spaulding.ladder.Entities.Ladder;
import com.spaulding.ladder.Entities.Room.Door;
import com.spaulding.ladder.Entities.Room.Key;

import java.util.ArrayList;

/**
 * Created by jared on 5/19/2016.
 */
public class Level1 {
    public Floor floor1, floor2, floor3, floor4, floor5, floor6;
    public Door door1;
    public Ladder ladder1, ladder2, ladder3;
    public Key key1;

    public final ArrayList<Key> keys;

    public Level1(){
        floor1 = new Floor(0,0);
        floor2 = new Floor(floor1.bounds.width + floor1.position.x, 0);
        floor3 = new Floor(0,180);
        floor4 = new Floor(floor3.bounds.width + floor3.position.x, 360);
        floor5 = new Floor(0, 540);
        floor6 = new Floor(floor5.bounds.width + floor5.position.x, 540);

        ladder1 = new Ladder(100, floor1.bounds.height, 90);
        ladder2 = new Ladder(floor3.bounds.width + 100, floor3.bounds.height, 270);
        ladder3 = new Ladder(0, floor3.bounds.height + floor3.position.y, 270);

        door1 = new Door(floor6.position.x + floor6.bounds.width - 165, 540 + floor5.bounds.height);

        key1 = new Key(floor4.position.x + 100, floor3.bounds.height + 360);

        keys = new ArrayList<Key>();
        keys.add(key1);
    }
}
