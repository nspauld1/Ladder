package com.spaulding.ladder.Entities.Enemies;

/**
 * Created by Nathan Spaulding on 5/19/2016.
 */
public interface Enemy {
    public String enemyName(String eName);
    public int enemyHealth(int eHealth);
    public int enemyDamage(int eDamage);
    public boolean hasWeapon(boolean eWeapon);

    //Walking pattern wont be int but for now
    public int walkingPattern(int pattern);

    public int enemyLocation(int eLoc);

}
