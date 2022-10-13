package com.TDA367group15.app.model;

public abstract class Combatable extends Entity {
    private int health;
    private int level;
    public Combatable(int x, int y) {
        super(x, y);
    }
}
