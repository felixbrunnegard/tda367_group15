package com.TDA367group15.app.view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel implements ViewInterface {
    //TODO tile size refactor this
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;

    //Screen settings
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn;
    final int screenRow = tileSize * maxScreenRow;

    public GameView(){
        this.setPreferredSize(new Dimension(screenWidth, screenRow));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void repaint(){
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose();
    }


}
