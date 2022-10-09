package com.TDA367group15.app.view;


import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.GameLoop;
import com.TDA367group15.app.model.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class SpriteView extends WorldView {

    private Player player;

    private Enemy enemy;

    private List<Enemy> enemies;
    private BufferedImage boyDown;
    private BufferedImage enemyDown;
    public SpriteView(Player player, List<Enemy> enemies){
        this.player = player;
        this.enemies = enemies;
        try {
            boyDown = ImageIO.read(new File("src/images/Player/boy_down_1.png"));
            enemyDown = ImageIO.read(new File("src/images/Enemy/enemy_down_1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void draw(Graphics2D g2){
        int xPos = GameView.SCREEN_WIDTH/2 - tileSize/2;
        int yPos = GameView.SCREEN_ROW /2 - tileSize/2;

        g2.drawImage(boyDown, xPos, yPos,tileSize,tileSize, null);


        for (int i = 0; i<5; i++ ){
            g2.drawImage(enemyDown, enemies.get(i).getPosition().getX(), enemies.get(i).getPosition().getY(), tileSize,tileSize, null);
        }
    }
}
