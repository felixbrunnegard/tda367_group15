package com.TDA367group15.app.model;

import java.util.ArrayList;

public class Player extends Combatable {
    private int overWorldHealth;
    private int maxHealth = 1;
    private final int baseXPToNextLevel = 100;


    public Player() {
        this(1488, 960);
    }

    /**
     * Creates a new player at the set coordinates
     * The player will get 4 preset abilites
     * @param x
     * @param y
     */
    public Player(int x, int y) {
        super(x, y);

        setMaxOverWorldHealth(6);
        setOverWorldHealth(6);

        //This creates a copy of the abilitylist in combatable then adds abilites to it then sets the list in combatible to the new lsit.

        ArrayList<Ability> newAbilityList = new ArrayList<Ability>(getAbilities());

        newAbilityList.add(new Ability("swordSwing", 10, 0, 90));
        newAbilityList.add(new Ability("firedance", 20, 0, 60));
        newAbilityList.add(new Ability("magicShield", 0, 15, 95));
        newAbilityList.add(new Ability("heavySwordSwing", 15, 0, 70));

        setAbilities(newAbilityList);

    }


    @Override
    /**
     * Sets the current experience
     * If experience exceeds xp to next level then a level up will occur and the xp needed will be subtracted
     * @param xP new xp to set
     */
    public void setXp(int xP) {
        super.setXp(xP);
        while (getXp() >= getXPToNextLevel()) {
           super.setXp(getXp() - getXPToNextLevel());
            setLevel(getLevel()+1);
            setHp(getMaxHP());
        }
    }

    /**
     * Calculates the xp needed to level up
     * @return total xp needed to level up
     */
    public int getXPToNextLevel() {
        return getLevel() * baseXPToNextLevel;

    }

    public int getOverWorldHealth() {
        return overWorldHealth;
    }

    public int getMaxOverWorldHealth() {
        return maxHealth;
    }

    protected void setOverWorldHealth(int health) {
        this.overWorldHealth = health;
    }

    protected void setMaxOverWorldHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void ReduceOverWorldHealth(int damage) {
        overWorldHealth -= damage;
    }
}
