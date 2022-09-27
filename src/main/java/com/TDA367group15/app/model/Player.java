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
        try {
            imageURL("/boy_down_1.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void attack(Enemy e){

    }



}
