package com.TDA367group15.app.view;


import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.GameLoop;
import com.TDA367group15.app.model.Player;

import java.awt.*;
import java.util.List;

public class SpriteView extends WorldView {

    @Override
    public void draw(Graphics2D g2){
        int xPos = GameView.SCREEN_WIDTH /2;
        int yPos = GameView.SCREEN_ROW /2;

        Player player = GameLoop.getPlayer();
        List<Enemy> enemies = GameLoop.getEnemies();

        g2.drawImage(player.getImage(), xPos, yPos,tileSize,tileSize, null);
        for (int i = 0; i<5; i++ ){
            g2.drawImage(enemies.get(i).getImage(), enemies.get(i).getPosX(), enemies.get(i).getPosY(), tileSize,tileSize, null);
        }
    }
}
