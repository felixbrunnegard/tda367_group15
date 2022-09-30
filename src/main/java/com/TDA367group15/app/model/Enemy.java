package com.TDA367group15.app.model;

import java.io.IOException;
import java.util.Random;

public class Enemy extends Combatable {
    public Enemy(){
        try {
            imageURL("src/images/Enemy/enemy_down_1.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int randomPosX(){
        Random ran = new Random();
        int x = ran.nextInt(500) + 1;
        return x;
    }

    public int randomPosY(){
        Random ran = new Random();
        int y = ran.nextInt(700) + 1;
        return y;
    }
    public void attack(){

    }
}
