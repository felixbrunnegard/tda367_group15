package com.TDA367group15.app.model;

import java.io.IOException;
import java.util.ArrayList;

public class Player extends Combatable{
    private int xP;
    private int overWorldHealth;
    private int maxHealth = 1;

    private int level = 1;

    private final int baseXPToNextLevel = 100;


    public Player(){
        this(1488,960);
    }
    public Player(int x, int y){
        super(x, y);

        setMaxOverWorldHealth(6);
        setOverWorldHealth(5);

        //This creates a copy of the abilitylist in combatable then adds abilites to it then sets the list in combatible to the new lsit.

        ArrayList<Ability> newAbilityList = new ArrayList<Ability>(getAbilities());

        newAbilityList.add(new Ability("swordSwing", 10, 0, 90));
        newAbilityList.add(new Ability("firedance", 20, 0, 60));
        newAbilityList.add(new Ability("magicShield", 0, 15, 95));
        newAbilityList.add(new Ability("heavySwordSwing", 15, 0, 70));

        setAbilities(newAbilityList);

    }


    public int getXP(){
        return this.xP;
    }
    protected void setXP(int xP){
        this.xP = xP;
        while(this.xP > getXPToNextLevel()){
            this.xP -= getXPToNextLevel();
            level ++;
        }
    }
    public int getLevel(){
        return this.level;
    }

    public int getXPToNextLevel(){
        return level*baseXPToNextLevel;
    }

    protected void setMaxOverWorldHealth(int maxHealth){this.maxHealth = maxHealth;}
    public int getMaxOverWorldHealth() {return maxHealth;}

    protected void setOverWorldHealth(int health){this.overWorldHealth = health;}
    public int getOverWorldHealth() {return overWorldHealth;}

    public void ReduceOverWorldHealth(int damage) {overWorldHealth -= damage;}

}
