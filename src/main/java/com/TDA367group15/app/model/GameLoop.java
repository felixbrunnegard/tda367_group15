package com.TDA367group15.app.model;

import com.TDA367group15.app.view.GameView;
import com.TDA367group15.app.view.ViewInterface;


import java.util.ArrayList;
import java.util.List;

public class GameLoop implements Runnable {
    private int FPS = 60;
    private GameView gameView = new GameView();
    private List<ViewInterface> gameViews = new ArrayList<>();


    // InitialiseView initialiseView = new InitialiseView();



    Thread gameThread;

    public GameLoop(){
        gameViews.add(gameView);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/(double)FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime)/drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= 1){
                //update
                gameView.repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: "+ drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }
    private void update(){

    }
}
