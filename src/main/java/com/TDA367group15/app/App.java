package com.TDA367group15.app;

import com.TDA367group15.app.model.GameLoop;
import com.TDA367group15.app.view.GameView;
import com.TDA367group15.app.view.ViewInterface;

import javax.swing.*;
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
        GameLoop gameLoop = GameLoop.getInstance();
        JFrame window = new JFrame();
        GameView gameView = new GameView();
        List<ViewInterface> gameViews = new ArrayList<>();
        gameViews.add(gameView);


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Blue Boy Adventure");
        window.add(gameView);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        //GameLoop gameLoop = new GameLoop();
        gameLoop.gameViews = gameViews;
        GameLoop.getInstance().run();
    }
}