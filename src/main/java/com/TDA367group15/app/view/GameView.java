package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.World;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.util.List;

public class GameView extends JPanel {
    public static final int SCREEN_WIDTH = 768;
    public static final int SCREEN_ROW = 576;
    private SpriteView spriteView;

    private HPView hpView;
    private  XPView xpView;

    private final World world;
    private TileView tileView;


    public GameView(World world){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_ROW));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.world = world;


        spriteView = new SpriteView(world.getPlayer(),world.getEnemies());
        hpView = new HPView(world.getPlayer());
        xpView = new XPView(world.getPlayer());
        tileView = new TileView(world.getPlayer());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        tileView.draw(g2);
        spriteView.draw(g2);
        hpView.draw(g2);
        xpView.draw(g2);



    }

    public void update(){
        repaint();
    }

    public TileView getTileView(){
        return tileView;
    }


}
