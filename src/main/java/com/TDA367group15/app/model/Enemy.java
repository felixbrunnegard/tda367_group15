package com.TDA367group15.app.model;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Combatable {
    private List<Enemy> enemies;

    public Enemy(Integer randomPosX, Integer randomPosY) {
        super(randomPosX, randomPosY);
    }
        public void attack () {

        }
        public List<Enemy> getEnemies() {
            return enemies;
        }
        @Override
        public boolean collide (Entity player){

            return false;
        }
    }

