package com.TDA367group15.app.model;

public class Player extends Combatable{
    private int xp;
    private int overWorldHealth;
    private int maxHealth = 1;


    public Player(){
        this(1488,960);
    }
    public Player(int x, int y){
        super(x, y);
        setMaxOverWorldHealth(6);
        setOverWorldHealth(5);
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

    public void attack(Enemy e){

    }

    public int getLevel(){
        return 1;
    }

}
