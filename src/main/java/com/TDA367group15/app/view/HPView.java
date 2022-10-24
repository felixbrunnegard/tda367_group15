package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Player;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HPView {
    private Player player;
    private int screenWidth;
    private int screenHeight;
    private int tileSize;

    private int xPos;
    private int yPos;
    private BufferedImage fullHealth;
    private BufferedImage halfHealth;
    private BufferedImage blankHealth;

    public HPView(Player player, int screenWidth, int screenHeight, int tileSize){
        this.player = player;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.tileSize = tileSize;
        this.xPos = screenWidth/2 - 100;
        this.yPos = screenHeight - 50;

        try {
            fullHealth = ImageIO.read(getClass().getResourceAsStream("/heart_full.png"));
            halfHealth = ImageIO.read(getClass().getResourceAsStream("/heart_half.png"));
            blankHealth = ImageIO.read(getClass().getResourceAsStream("/heart_blank.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2) {
        drawRoundRectangle(g2);
        drawHearts(g2);
    }

    /**
     * Draws the orange background behind the hearts
     * @param g2
     */
    private void drawRoundRectangle(Graphics2D g2) {
        RoundRectangle2D roundRectangle2D = new RoundRectangle2D.Float(xPos + 26,screenHeight - 55 , 150, 55, 25, 25);
        RoundRectangle2D backgroundToHearts = new RoundRectangle2D.Float(xPos + 28,screenHeight - 52 , 145, 50, 25, 25);

        g2.setColor(Color.ORANGE);
        g2.fill(roundRectangle2D);
        g2.draw(roundRectangle2D);

        g2.setColor(Color.WHITE);
        g2.fill(backgroundToHearts);
        g2.draw(backgroundToHearts);
    }

    /**
     * Draws the hearts based on the player health and maxHp
     * @param g2
     */
    private void drawHearts(Graphics2D g2) {
        int maxHP = player.getMaxOverWorldHealth();
        int hp = player.getOverWorldHealth();

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

