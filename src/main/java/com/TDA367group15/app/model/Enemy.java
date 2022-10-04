package com.TDA367group15.app.model;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Combatable {

    public Enemy(Integer randomPosX,Integer randomPosY ){
        super(randomPosX,randomPosY);

        try {
            imageURL("src/images/Enemy/enemy_down_1.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void attack(){

    }

    @Override
    public boolean collide(Entity player) {

        return false;
    }
}
