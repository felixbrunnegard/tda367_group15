package com.TDA367group15.app.model;

import com.TDA367group15.app.controller.KeyHandler;
import com.TDA367group15.app.controller.PlayerController;
import com.TDA367group15.app.view.ViewInterface;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLoop implements Runnable {

    private static Player player; // only one instance, everyone share it.
    private static List<Enemy> enemies;
    private int FPS = 60;
    public List<ViewInterface> gameViews;
    public KeyHandler keyH;
    public PlayerController playerC;

     Thread gameThread;

    public GameLoop(KeyHandler keyH){
        this.player = new Player();
        this.enemies = new ArrayList<>(5);
        this.keyH = keyH;
        this.playerC = new PlayerController(player);

        for (int i = 0; i<5; i++ ){
            Random ran = new Random();
            int randomX = ran.nextInt(567);
            int randomY = ran.nextInt(792);
            Enemy enemy = new Enemy(randomX,randomY);
            enemies.add(enemy);
        }
    }

    public static Player getPlayer(){
        return player;
    }

    public static List<Enemy> getEnemies(){
        return enemies;
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
                //System.out.println("FPS: "+ drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    private void update(){
        gameViews.get(0).update();
        if(keyH.getDirectionPressed() != null) {
            playerC.actOnMovement(keyH.getDirectionPressed());
        }
    }
}
