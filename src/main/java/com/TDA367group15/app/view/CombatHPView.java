package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

/**
 * This is the object that creates the players HP box and the enemy's HP box in the combat view.
 */
public class CombatHPView {

    private Player player;
    private Enemy enemy;

    private int playerHPBoxPosX;
    private int playerHPBoxPosY;
    private int enemyHPBoxPosX;
    private int enemyHPBoxPosY;
    private int HPBoxWidth;
    private int HPBoxHeight;

    private int playerHPBarPosX;
    private int playerHPBarPosY;
    private int enemyHPBarPosX;
    private int enemyHPBarPosY;
    private int HPBarWidth;
    private int HPBarHeight;

    private int archSize = 10;

    /**
     * Constructs the object that contains a players HP box and an enemy's HP box. The constructor scales the size
     * and position of the HP boxes depending on screen size.
     * @param player The player that should be displayed in combat.
     * @param enemy The enemy that should be displayed in combat.
     * @param gameWidth The width of the window
     * @param gameHeight The height of the window.
     */
    public CombatHPView(Player player, Enemy enemy, int gameWidth, int gameHeight) {
        this.player = player;
        this.enemy = enemy;
        this.playerHPBoxPosX = (int) (gameWidth * 0.6);
        this.enemyHPBoxPosX = (int) (gameWidth * 0.1);
        this.playerHPBoxPosY = (int) (gameHeight * 0.5);
        this.enemyHPBoxPosY = (int) (gameHeight * 0.1);
        this.HPBoxWidth = (int) (gameWidth * 0.25);
        this.HPBoxHeight = (int) (gameHeight * 0.18);

        this.playerHPBarPosX = (int) (playerHPBoxPosX + (HPBoxWidth * 0.1));
        this.enemyHPBarPosX = (int) (enemyHPBoxPosX + (HPBoxWidth * 0.1));
        this.playerHPBarPosY = (int) (playerHPBoxPosY + (HPBoxHeight * 0.4));
        this.enemyHPBarPosY = (int) (enemyHPBoxPosY + (HPBoxHeight * 0.4));
        this.HPBarWidth = (int) (HPBoxWidth * 0.8);
        this.HPBarHeight = (int) (HPBoxHeight * 0.2);
    }

    /**
     * The main draw method that renders the players HP box and the enemy's HP Box.
     * @param g2
     */
    public void draw(Graphics2D g2){
        drawEnemyHPBoxEdge(g2);
        drawEnemyHPBox(g2);
        drawEnemyHPEdge(g2);
        drawEnemyHP(g2);
        drawEnemyLevel(g2);

        drawPlayerHPBoxEdge(g2);
        drawPlayerHPBox(g2);
        drawPlayerHPEdge(g2);
        drawPlayerHP(g2);
        drawPlayerLevel(g2);
    }

    /**
     * Renders the black border of the enemy's HP Box.
     * @param g2
     */
    public void drawEnemyHPBoxEdge(Graphics2D g2){
        RoundRectangle2D HPBoxEdge = new RoundRectangle2D.Float(enemyHPBoxPosX-2, enemyHPBoxPosY-2, HPBoxWidth+4, HPBoxHeight+4, archSize, archSize);

        g2.setColor(Color.BLACK);
        g2.fill(HPBoxEdge);
        g2.draw(HPBoxEdge);
    }

    /**
     * Renders the main white HP box of the enemy.
     * @param g2
     */
    public void drawEnemyHPBox(Graphics2D g2){
        RoundRectangle2D HPBox = new RoundRectangle2D.Float(enemyHPBoxPosX, enemyHPBoxPosY, HPBoxWidth, HPBoxHeight, archSize, archSize);

        g2.setColor(Color.WHITE);
        g2.fill(HPBox);
        g2.draw(HPBox);
    }

    /**
     * Renders a text on the HP box of the enemy's level.
     * @param g2
     */
    public void drawEnemyLevel(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.PLAIN, 21));
        g2.drawString("LV " + enemy.getLevel(), enemyHPBoxPosX + 10, enemyHPBoxPosY + 21);
    }

    /**
     * Renders the black border of the HP bar on enemy's HP box.
     * @param g2
     */
    public void drawEnemyHPEdge(Graphics2D g2){
        RoundRectangle2D HPBarEdge = new RoundRectangle2D.Float(enemyHPBarPosX-2, enemyHPBarPosY-2, HPBarWidth+4, HPBarHeight+4, archSize, archSize);

        g2.setColor(Color.BLACK);
        g2.fill(HPBarEdge);
        g2.draw(HPBarEdge);
    }

    /**
     * Renders the main red HP bar on the enemy's HP box that changes width depending on enemy's HP.
     * @param g2
     */
    public void drawEnemyHP(Graphics2D g2){
        RoundRectangle2D HPBarEdge = new RoundRectangle2D.Float(enemyHPBarPosX, enemyHPBarPosY, HPBarWidth * (enemy.getHp() / enemy.getMaxHP()), HPBarHeight, archSize, archSize);

        g2.setColor(Color.RED);
        g2.fill(HPBarEdge);
        g2.draw(HPBarEdge);
    }

    /**
     * Renders the black border of the players HP Box.
     * @param g2
     */
    public void drawPlayerHPBoxEdge(Graphics2D g2){
        RoundRectangle2D HPBoxEdge = new RoundRectangle2D.Float(playerHPBoxPosX-2, playerHPBoxPosY-2, HPBoxWidth+4, HPBoxHeight+4, archSize, archSize);

        g2.setColor(Color.BLACK);
        g2.fill(HPBoxEdge);
        g2.draw(HPBoxEdge);
    }

    /**
     * Renders the main white HP box of the player.
     * @param g2
     */
    public void drawPlayerHPBox(Graphics2D g2){
        RoundRectangle2D HPBox = new RoundRectangle2D.Float(playerHPBoxPosX, playerHPBoxPosY, HPBoxWidth, HPBoxHeight, archSize, archSize);

        g2.setColor(Color.WHITE);
        g2.fill(HPBox);
        g2.draw(HPBox);
    }

    /**
     * Renders a text on the HP box of the players level.
     * @param g2
     */
    public void drawPlayerLevel(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.PLAIN, 21));
        g2.drawString("LV " + player.getLevel(), playerHPBoxPosX + 10, playerHPBoxPosY + 21);
    }

    /**
     * Renders the black border of the HP bar on players HP box.
     * @param g2
     */
    public void drawPlayerHPEdge(Graphics2D g2){
        RoundRectangle2D HPBarEdge = new RoundRectangle2D.Float(playerHPBarPosX-2, playerHPBarPosY-2, HPBarWidth+4, HPBarHeight+4, archSize, archSize);

        g2.setColor(Color.BLACK);
        g2.fill(HPBarEdge);
        g2.draw(HPBarEdge);
    }

    /**
     * Renders the main red HP bar on the enemy's HP box that changes width depending on players HP.
     * @param g2
     */
    public void drawPlayerHP(Graphics2D g2){
        RoundRectangle2D HPBarEdge = new RoundRectangle2D.Float(playerHPBarPosX, playerHPBarPosY, HPBarWidth * (player.getHp() / player.getMaxHP()), HPBarHeight, archSize, archSize);

        g2.setColor(Color.RED);
        g2.fill(HPBarEdge);
        g2.draw(HPBarEdge);
    }
}
