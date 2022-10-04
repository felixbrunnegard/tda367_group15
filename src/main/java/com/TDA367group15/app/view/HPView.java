package com.TDA367group15.app.view;

import com.TDA367group15.app.model.GameLoop;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HPView extends HUDView {
    private BufferedImage fullHealth;
    private BufferedImage halfHealth;
    private BufferedImage blankHealth;

    public HPView(){
        super();
        try {
            fullHealth = ImageIO.read(new File("src/images/Player/heart_full.png"));
            halfHealth = ImageIO.read(new File("src/images/Player/heart_half.png"));
            blankHealth = ImageIO.read(new File("src/images/Player/heart_blank.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void draw(Graphics2D g2) {
        int maxHP = GameLoop.getPlayer().getMaxHealth();
        int hp = GameLoop.getPlayer().getHealth();
        int xPos = GameView.SCREEN_WIDTH/2 - 75;
        int yPos = GameView.SCREEN_ROW - 50;

        for(int i = 1; i <= maxHP; i += 2){
            if (i < hp){
                g2.drawImage(fullHealth, xPos + (25*i), yPos,tileSize, tileSize, null);
            }
            else if (i == hp) {
                g2.drawImage(halfHealth, xPos + (25*i), yPos,tileSize, tileSize, null);
            }
            else{
                g2.drawImage(blankHealth, xPos + (25*i), yPos,tileSize, tileSize, null);
            }
        }
    }
}
