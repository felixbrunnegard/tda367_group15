package com.TDA367group15.app.view;

import com.TDA367group15.app.GameLoop;
import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.World;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

public class GameView extends JPanel {
    private final int SCREEN_WIDTH = 768;
    private final int SCREEN_HEIGHT = 576;
    private int[][] mapTileNum;

    private WorldView worldView;
    private CombatView combatView;
    private final World world;

    public GameView(World world, int[][] mapTileNum){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setLayout(null);
        this.world = world;
        this.mapTileNum = mapTileNum;

        this.worldView = new WorldView(SCREEN_WIDTH, SCREEN_HEIGHT, world, mapTileNum);

        this.combatView = new CombatView(world.getPlayer(), world.getEnemies().get(0), SCREEN_WIDTH, SCREEN_HEIGHT);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (world.isGameOver()){
            this.removeAll();
            String text = "GAME OVER";
            setFont(g2, text);
        }

        else if (world.isVictory()){
            this.removeAll();
            String text = "Victory!";
            setFont(g2, text);
        }
        else if(!world.isCombat()){
            this.removeAll();
            combatView.setAbilityButtonsVisibility(false);
            worldView.draw(g2);
        }
        else {


            for (int i = 0; i < combatView.getAbilityButtons().size(); i++){
                this.add(combatView.getAbilityButtons().get(i));
            }

            combatView.setAbilityButtonsVisibility(true);
            combatView.draw(g2);
        }


    }

    private void setFont(Graphics2D g2, String text) {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));

        int x = getXCordForCenteredText(g2,text);
        int y =  getYCordForCenteredText(g2, text);

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
    }

    public void update(){
        repaint();
    }

    public WorldView getWorldView(){
        return this.worldView;
    }

    public CombatView getCombatView(){
        return this.combatView;
    }

    public void setCombatView(Enemy enemyInCombat){
        combatView = new CombatView(world.getPlayer(), enemyInCombat, SCREEN_WIDTH, SCREEN_HEIGHT);

        for (int i = 0; i < combatView.getAbilityButtons().size(); i++){
            this.add(combatView.getAbilityButtons().get(i));
        }

        combatView.setAbilityButtonsVisibility(false);
    }

    public int[][] getMapTileNum(){
        return mapTileNum;
    }

    private int getXCordForCenteredText(Graphics2D g2, String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return SCREEN_WIDTH/2 - length/2;
    }

    private int getYCordForCenteredText(Graphics2D g2, String text){
        int height = (int)g2.getFontMetrics().getStringBounds(text, g2).getHeight();
        return SCREEN_HEIGHT/2 + height/4;
    }


}
