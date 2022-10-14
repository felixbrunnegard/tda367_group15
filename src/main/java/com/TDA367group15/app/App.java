package com.TDA367group15.app;

import com.TDA367group15.app.controller.KeyHandler;
import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.view.GameView;

import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.List;

import static com.TDA367group15.app.view.WorldView.tileSize;

/**
 * Hello world!
 *
 */
public class App
{

    public static void main( String[] args )
    {

        Player player = new Player();
        List<Enemy> enemies = new ArrayList<>(5);

        enemies.add(new Enemy(21*tileSize, 380));
        enemies.add(new Enemy(15*tileSize, 900));
        enemies.add(new Enemy(32*tileSize, 580));
        enemies.add(new Enemy(221, 39*tileSize));
        enemies.add(new Enemy(56*tileSize, 750));

        KeyHandler keyH = new KeyHandler();
        GameLoop gameLoop = new GameLoop(player,enemies, keyH);
        JFrame window = new JFrame();
        GameView gameView = new GameView(player, enemies);
        List<GameView> gameViews = new ArrayList<>();
        gameViews.add(gameView);


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Blue Boy Adventure");
        window.add(gameView);
        window.setFocusable(true);
        window.addKeyListener(keyH);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //GameLoop gameLoop = new GameLoop();
        gameLoop.gameViews = gameViews;
        gameLoop.startGameThread();
        gameLoop.run();
    }
}