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

public class GameView extends JPanel {
    private final int SCREEN_WIDTH = 768;
    private final int SCREEN_ROW = 576;
    private int[][] mapTileNum;

    private WorldView worldView;
    private CombatView combatView;
    private final World world;

    public GameView(World world, int[][] mapTileNum){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_ROW));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setLayout(null);
        this.world = world;
        this.mapTileNum = mapTileNum;

        this.worldView = new WorldView(SCREEN_WIDTH, SCREEN_ROW, world, mapTileNum);

        this.combatView = new CombatView(world.getPlayer(), world.getEnemies().get(0), SCREEN_WIDTH, SCREEN_ROW);

        for (int i = 0; i < combatView.getAbilityButtons().size(); i++){
            this.add(combatView.getAbilityButtons().get(i));
        }

        this.combatView.setAbilityButtonsVisibility(false);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        if (world.isGameOver()){
            System.out.println("Game Over");
        }
        else if(!world.isCombat()){
            worldView.draw(g2);
        }
        else {
            combatView.draw(g2);

            combatView.setAbilityButtonsVisibility(true);
        }


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
        combatView = new CombatView(world.getPlayer(), enemyInCombat, SCREEN_WIDTH, SCREEN_ROW);

        for (int i = 0; i < combatView.getAbilityButtons().size(); i++){
            this.add(combatView.getAbilityButtons().get(i));
        }

        combatView.setAbilityButtonsVisibility(false);
    }

    public int[][] getMapTileNum(){
        return mapTileNum;
    }


}
