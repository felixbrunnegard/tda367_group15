package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameView extends JPanel implements ViewInterface {
    public static final int SCREEN_WIDTH = 768;
    public static final int SCREEN_ROW = 576;
    SpriteView spriteView;

    HPView hpView;
    XPView xpView;

    Player player;
    List<Enemy> enemies;
    TileView tileView;


    public GameView(Player player, List<Enemy> enemies){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_ROW));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.player = player;
        this.enemies = enemies;


        spriteView = new SpriteView(player,enemies);
        hpView = new HPView(player);
        xpView = new XPView(player);
        tileView = new TileView(player);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        tileView.draw(g2);
        spriteView.draw(g2);
        hpView.draw(g2);
        xpView.draw(g2);



    }

    @Override
    public void update(){
        repaint();
    }

    public TileView getTileView(){
        return tileView;
    }


}
