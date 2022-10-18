package com.TDA367group15.app.model;

public class Player extends Combatable{
    private int xP;
    private int overWorldHealth;
    private int maxHealth = 1;
    private int movementSpeed;

    private int level = 1;

    private final int baseXPToNextLevel = 100;


    public Player(){
        this(1488,960,2);
    }
    public Player(int x, int y, int speed){
        super(x, y);
        setMaxOverWorldHealth(6);
        setOverWorldHealth(5);
        this.movementSpeed = speed;
    }

    public int getOverWorldHealth() {
        return overWorldHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    protected void setOverWorldHealth(int health){
        this.overWorldHealth = health;
    }

    protected void setMaxOverWorldHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }

    public void ReduceOverWorldHealth(int damage) {
        overWorldHealth -= damage;
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

    public int getMovementSpeed() {
        return movementSpeed;
    }
}
