package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.World;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;

public class XPView {
    private Player player;
    private int screenWidth;
    private int baseXPRectanglePosX;
    private int baseXPRectanglePosY = 10;

    private int baseXPRectangleWidth = 300;

    public XPView(Player player, int screenWidth){

        this.player = player;
        this.screenWidth = screenWidth;
        this.baseXPRectanglePosX = screenWidth/2 - 150;

    }

    public void draw(Graphics2D g2) {
        drawRoundRectangleEdge(g2);
        drawRoundRectangleBackground(g2);
        drawRoundRectangleXP(g2);
        drawLevel(g2);
    }

    /**
     * Draws the orange border around the xp bar
     * @param g2
     */
    private void drawRoundRectangleEdge(Graphics2D g2) {
        RoundRectangle2D roundRectangle2D = new RoundRectangle2D.Float(baseXPRectanglePosX-2, baseXPRectanglePosY-2, baseXPRectangleWidth+4, 24, 25, 25);

        g2.setColor(Color.ORANGE);
        g2.fill(roundRectangle2D);
        g2.draw(roundRectangle2D);
    }

    /**
     * Draws the black bar (the xp not yet filled out)
     * @param g2
     */
    private void drawRoundRectangleBackground(Graphics2D g2) {
        RoundRectangle2D roundRectangle2D1 = new RoundRectangle2D.Float(baseXPRectanglePosX, baseXPRectanglePosY, baseXPRectangleWidth, 20, 25, 25);

        g2.setColor(Color.BLACK);
        g2.fill(roundRectangle2D1);
        g2.draw(roundRectangle2D1);
    }

    /**
     * Draws the experience bar based on how much experience the player has left to level up
     * @param g2
     */
    private void drawRoundRectangleXP(Graphics2D g2) {
        float width = baseXPRectangleWidth * ((float)player.getXp() / (float)player.getXPToNextLevel());
        float posX = baseXPRectanglePosX + (baseXPRectangleWidth - width);

        RoundRectangle2D roundRectangle2D2 = new RoundRectangle2D.Float(posX, baseXPRectanglePosY, width, 20, 25, 25);

        g2.setColor(Color.BLUE);
        g2.fill(roundRectangle2D2);
        g2.draw(roundRectangle2D2);
    }

    /**
     * Draws the current level of the player on the xP bar
     * @param g2
     */
    private void drawLevel(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.drawString("LV"+ player.getLevel(), screenWidth/2 + 120, 25);
    }

}
