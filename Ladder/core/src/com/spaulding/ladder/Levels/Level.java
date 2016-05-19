package com.spaulding.ladder.Levels;

/**
 * Created by jared on 5/19/2016.
 */
public interface Level {

    public void charNum(int num);
    public void ladders(int num);
    public void floorsNum(int num);

    public void getBots();
    public void setBotsLocation();

    public void getCharacter();
    public void setCharatcerLocation();



}
