package com.TDA367group15.app.model;

public class Friendly extends Entity {
    private boolean interactable;

    public void interact(Player p){
    }

    @Override
    public boolean collide(Entity player) {
        return false;
    }
}
