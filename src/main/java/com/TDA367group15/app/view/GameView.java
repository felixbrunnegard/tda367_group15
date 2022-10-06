package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.GameLoop;
import com.TDA367group15.app.model.Player;

import javax.swing.*;
import java.awt.*;
public class GameView extends JPanel implements ViewInterface {
    public static final int SCREEN_WIDTH = 768;
    public static final int SCREEN_ROW = 576;

    GameLoop gameLoop = GameLoop.getInstance();

    TileView tileView = new TileView();
    SpriteView spriteView;
    HPView hpView;

    public GameView(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_ROW));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        spriteView = new SpriteView();
        hpView = new HPView();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        if (!gameLoop.isCombat()){
            tileView.draw(g2);
            spriteView.draw(g2);
            hpView.draw(g2);
        }
        else {
            //Fyll med kod som ska visa combaten
        }
    }

    @Override
    public void update(){
        repaint();
    }

}
