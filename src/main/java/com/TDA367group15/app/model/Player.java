package com.TDA367group15.app.model;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class Player extends Combatable{
    private int xp;
    private int overWorldHealth;
    //JFrame frame = ;

    public Player(){
        this(0,0);
    }
    public Player(int x, int y){
        super(x, y);
        setMaxHealth(6);
        setHealth(3);
    }

    public void attack(Enemy e){

    }

    public int getLevel() {
        return 1;
    }
}
