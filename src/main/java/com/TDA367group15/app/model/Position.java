package com.TDA367group15.app.model;

/**
 * Class similar to a Vector2
 * This is only a holder for X and Y coordinates
 */
public class Position {

    private int x;
    private int y;

    public Position(int posX, int posY){
        this.x = posX;
        this.y = posY;
    }

    public void moveX(int xDir){
        this.x += xDir;
    }

    public void moveY(int yDir){
        this.y += yDir;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

}
