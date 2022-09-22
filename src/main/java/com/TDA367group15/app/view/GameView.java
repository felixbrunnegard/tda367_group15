package com.TDA367group15.app.view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel implements ViewInterface {

    //Screen settings
    final int screenWidth = 768;
    final int screenRow = 576;

    TileView tileView = new TileView();

    public GameView(){
        this.setPreferredSize(new Dimension(screenWidth, screenRow));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileView.draw(g2);

    }

    @Override
    public void update(){
        repaint();
    }

}
