package com.TDA367group15.app.model;

public abstract class Combatable extends Entity {
    private int helalth;
    private int level;

    public Combatable(){
        super();
    }
    public Combatable(int x, int y) {
        super(x, y);
    }
}
