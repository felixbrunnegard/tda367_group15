package com.TDA367group15.app;

import com.TDA367group15.app.controller.KeyHandler;
import com.TDA367group15.app.controller.PlayerController;
import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.view.ViewInterface;


import java.util.ArrayList;
import java.util.List;

public class GameLoop implements Runnable {

    private Player player; // only one instance, everyone share it.

    private List<Enemy> enemies;
    private int fps = 60;
    public List<ViewInterface> gameViews;
    public KeyHandler keyH;
    public PlayerController playerC;

    private Thread gameThread;

    public GameLoop(Player player, KeyHandler keyH){
        this.player = player;
        this.enemies = new ArrayList<>(5);
        this.keyH = keyH;
        this.playerC = new PlayerController(player);


    }

    /*public static Player getPlayer(){
        return player;
    }*/

    public List<Enemy> getEnemies(){
        return enemies;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/(double) fps;
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
