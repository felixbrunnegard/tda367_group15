package com.TDA367group15.app.model;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Combatable {
    int x ;
    int y ;
    public Enemy(Integer randomPosX,Integer randomPosY ){
        this.x = randomPosX;
        this.y = randomPosY;

        try {
            imageURL("src/images/Enemy/enemy_down_1.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int getPosX(){
        return x;
    }

    public int getPosY(){
        return x;
    }
    public void attack(){

    }
}
