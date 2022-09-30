package com.TDA367group15.app.model;

import com.TDA367group15.app.view.GameView;
import com.TDA367group15.app.view.ViewInterface;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLoop implements Runnable {

    private Player player;
    private List<Enemy> enemies ;
    private int FPS = 60;
    public List<ViewInterface> gameViews;

    Thread gameThread;

    public GameLoop(){
        this.player = new Player();
        this.enemies = new ArrayList<>(5);
        for (int i = 0; i<5; i++ ){
            Random ran = new Random();
            int randomX = ran.nextInt(500) + 1;
            int randomY = ran.nextInt(700) + 1;
            Enemy enemy = new Enemy(randomX,randomY);
            this.enemies.add(enemy);
        }
    }
    public Player getPlayer(){
        return this.player;
    }

    public List<Enemy> getEnemy(){
        return this.enemies;
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
                update();
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
        gameViews.get(0).update();
    }
}
