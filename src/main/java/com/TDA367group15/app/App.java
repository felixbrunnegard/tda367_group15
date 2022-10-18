package com.TDA367group15.app;

import com.TDA367group15.app.controller.KeyHandler;
import com.TDA367group15.app.controller.PlayerController;
import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.World;
import com.TDA367group15.app.view.GameView;
import com.TDA367group15.app.view.WorldView;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Player player = new Player();
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy(21* WorldView.tileSize, 380));
        enemies.add(new Enemy(15*WorldView.tileSize, 900));
        enemies.add(new Enemy(32*WorldView.tileSize, 580));
        enemies.add(new Enemy(221, 39*WorldView.tileSize));
        enemies.add(new Enemy(56*WorldView.tileSize, 750));


        World world = new World(player,enemies );
        PlayerController playerC = new PlayerController(player);
        KeyHandler keyH = new KeyHandler();
        GameLoop gameLoop = new GameLoop(keyH, playerC, world);
        JFrame window = new JFrame();

        GameView gameView = new GameView(world);
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

        gameLoop.setGameViews(gameViews);
        gameLoop.startGameThread();
        gameLoop.run();
    }
}