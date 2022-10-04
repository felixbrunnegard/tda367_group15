package com.TDA367group15.app.model;

public abstract class Combatable extends Entity {
    private int health;
    private int maxHealth = 1;
    private int level;

    public Combatable(){
        super();
    }
    public Combatable(int x, int y) {
        super(x, y);
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    protected void setHealth(int health){
        this.health = health;
    }

    protected void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }

    public void ReduceHealth(int damage) {
        health -= damage;
    }
}
