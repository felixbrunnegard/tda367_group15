package com.TDA367group15.app;

import com.TDA367group15.app.model.GameLoop;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        GameLoop gameLoop = new GameLoop();
        gameLoop.startGameThread();
        gameLoop.run();
    }
}