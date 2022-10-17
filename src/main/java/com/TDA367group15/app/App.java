package com.TDA367group15.app;

import com.TDA367group15.app.controller.KeyHandler;
import com.TDA367group15.app.controller.PlayerController;
import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.World;
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

        World world = new World(player);
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