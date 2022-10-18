package com.TDA367group15.app.model;


public class Tile implements ICollidable {

    private boolean collision;
    private int tileID;
    private boolean collideWithTile;

    public Tile(int tileID){
        this.tileID = tileID;
    }

    public int getTileNr(){
        return tileID;
    }

    public boolean isCollideWithTile() {
        return collideWithTile;
    }

    @Override
    public boolean collide(Entity player) {

        int tileNr = getTileNr();

        if(tileNr == 7){
            return collideWithTile = true;
        }
        if(tileNr == 2){
            return collideWithTile = true;
        }
        if(tileNr == 5){
            return collideWithTile = true;
        }
        return collideWithTile = false;
    }

}

