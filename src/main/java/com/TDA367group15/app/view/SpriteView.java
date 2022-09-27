package com.TDA367group15.app.view;


import com.TDA367group15.app.model.Player;

import java.awt.*;

public class SpriteView extends WorldView {

    private Player player;
    public SpriteView(Player player){
        this.player = player;
    }

    @Override
    public void draw(Graphics2D g2){
        int xPos = GameView.SCREEN_WIDTH /2;
        int yPos = GameView.SCREEN_ROW /2;
        g2.drawImage(player.getImage(), xPos, yPos,tileSize,tileSize, null);
    }
}
