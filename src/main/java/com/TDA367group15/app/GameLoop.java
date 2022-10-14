package com.TDA367group15.app;

import com.TDA367group15.app.controller.KeyHandler;
import com.TDA367group15.app.controller.PlayerController;
import com.TDA367group15.app.model.*;
import com.TDA367group15.app.view.GameView;
import com.TDA367group15.app.view.ViewInterface;


import java.util.ArrayList;
import java.util.List;

public class GameLoop implements Runnable {
    private int fps = 60;
    private List<GameView> gameViews;
    public KeyHandler keyH;
    public PlayerController playerC;

    private World world;

    private Thread gameThread;

    public GameLoop(KeyHandler keyH, PlayerController playerC, World world){
        this.keyH = keyH;
        this.playerC = playerC;
        this.world = world;
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
            if (!willPlayerCollideWithTile() && !willPlayerCollideWithEnemy()) {
                playerC.actOnMovement(keyH.getDirectionPressed());
            }
        }
    }

    private boolean willPlayerCollideWithEnemy(){
        Player player = world.getPlayer();
        for(Enemy e : world.getEnemies()) {
            if(player.willPlayerCollideWithEntityInCurrentDirection(e, keyH.getDirectionPressed())){
                return true;
            }
        }
        return false;
    }

    private boolean willPlayerCollideWithTile(){
        Player player = world.getPlayer();
        int xPos = player.getPosition().getX();
        int yPos = player.getPosition().getY();
        int tilePosX = xPos / gameViews.get(0).getTileView().tileSize;
        int tilePosY = yPos / gameViews.get(0).getTileView().tileSize;
        if (keyH.getDirectionPressed() != null) {
            if (keyH.getDirectionPressed() == Direction.UP) {
                tilePosY--;
            } else if (keyH.getDirectionPressed() == Direction.DOWN) {
                tilePosY++;
            } else if (keyH.getDirectionPressed() == Direction.LEFT) {
                tilePosX--;
            } else {
                tilePosX++; //RIGHT
            }
        }

        //MapTileNum and Tiles probably should not be in tileView?
        int nextTile = gameViews.get(0).getTileView().getMapTileNum()[tilePosY][tilePosX];
        Tile tileToCheckCollide = new Tile(nextTile);
        if (tileToCheckCollide.collide(player)) {
        } else {
            playerC.actOnMovement(keyH.getDirectionPressed());
        }

        return tileToCheckCollide.collide(player);
    }

    public void setGameViews(List<GameView> gameViews) {
        this.gameViews = gameViews;
    }
}
