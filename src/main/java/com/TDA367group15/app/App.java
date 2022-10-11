package com.TDA367group15.app;

import com.TDA367group15.app.controller.KeyHandler;
import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.view.GameView;
import com.TDA367group15.app.view.ViewInterface;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        for (int i = 0; i<5; i++ ){
            Random ran = new Random();
            int randomX = ran.nextInt(567);
            int randomY = ran.nextInt(792);
            Enemy enemy = new Enemy(randomX,randomY);
            enemies.add(enemy);
        }

        KeyHandler keyH = new KeyHandler();
        GameLoop gameLoop = new GameLoop(player, keyH);
        JFrame window = new JFrame();
        GameView gameView = new GameView(player, enemies);
        List<ViewInterface> gameViews = new ArrayList<>();
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