package com.TDA367group15.app.model;

import com.TDA367group15.app.view.GameView;

public class Tile implements ICollidable {

    private boolean collision;
    public int tileID;
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

        Position playerPos = player.getPosition();
        int tileNr = getTileNr();

        int xDiff = playerPos.getX() - tileNr;
        int yDiff = playerPos.getY() - tileNr;
        if(xDiff <= 0 || yDiff <= 0){
            return collideWithTile = true;
        }
        return collideWithTile = false;
    }

}

