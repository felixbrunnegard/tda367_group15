package com.TDA367group15.app.model;

//https://noobtuts.com/java/vector2-class
public class Position {

    // är inte float bättre då det är mycket mer uttrym att flytta sig på
    private int x;
    private int y;

    public Position() {
        this(0,0);
    }

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
