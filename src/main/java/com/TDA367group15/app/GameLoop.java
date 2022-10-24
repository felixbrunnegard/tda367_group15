package com.TDA367group15.app;

import com.TDA367group15.app.controller.CombatController;
import com.TDA367group15.app.controller.KeyHandler;
import com.TDA367group15.app.controller.PlayerController;
import com.TDA367group15.app.model.*;
import com.TDA367group15.app.view.GameView;


import java.util.ArrayList;
import java.util.List;

public class GameLoop implements Runnable {
    private int fps = 60;
    private List<GameView> gameViews;
    public KeyHandler keyH;
    public PlayerController playerC;
    private CombatController combatController;

    private World world;

    private Thread gameThread;

    public GameLoop(KeyHandler keyH, PlayerController playerC, World world, CombatController combatController){
        this.keyH = keyH;
        this.playerC = playerC;
        this.world = world;
        this.combatController = combatController;
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
                drawCount = 0;
                timer = 0;
            }
        }
    }
    private void update(){

        if (world.getPlayer().getOverWorldHealth() <= 0){

            world.setGameOver();
        }

        gameViews.get(0).update();
        if(keyH.getDirectionPressed() != null) {
            if (!willPlayerCollideWithTile() && !willPlayerCollideWithEnemy(keyH.getDirectionPressed())) {
                playerC.actOnMovement(keyH.getDirectionPressed());
            }else if(willPlayerCollideWithEnemy(keyH.getDirectionPressed())){
                if (getEnemyCollidedWith(keyH.getDirectionPressed()) != null) {
                    world.toCombat();
                    world.setEnemyInCombat(getEnemyCollidedWith(keyH.getDirectionPressed()));
                    gameViews.get(0).setCombatView(world.getEnemyInCombat());
                    combatController.setCombatView(gameViews.get(0).getCombatView());
                    combatController.setCombat(new Combat(world));
                    combatController.setPlayer(world.getPlayer());
                    combatController.setEnemy(world.getEnemyInCombat());
                    combatController.setCombatButtons();
                    combatController.setButtonsAction();
                }
                //Shift player position up again so it will not collide immediatly again.

            }
        }
    }

    /**
     * Uses "getEnemyCollideWith" to see if the player will collide with an enemy in the current direction
     * @param direction
     * @return true if player will collide with an enemy
     */
    private boolean willPlayerCollideWithEnemy(Direction direction){
        return getEnemyCollidedWith(direction) != null;
    }

    /**
     * Checks if the player will collide with an ememy based on the players current direction
     * This is done by making a copy of the player, moving it in the provided direction and then see if it collides with an enemy
     * @param direction the direction the player is attempting to move in
     * @return The enemy the player will collide with, null if it does not collide with an enemy
     */
    public Enemy getEnemyCollidedWith(Direction direction){
        Player player = world.getPlayer();
        Player copy = new Player(player.getPosition().getX(), player.getPosition().getY());
        copy.move(direction);
        for(Enemy e : world.getEnemies()) {
            if(copy.collide(e)){
                return e;
            }
        }
        return null;
    }

    /**
     * Checks if the player will collide with a tile that is not passable
     * This is done by checking the direction and position of the player and see which the next tile in that direction will be
     * @return True if collide with a none passable tile
     */
    private boolean willPlayerCollideWithTile(){
        Player player = world.getPlayer();
        int xPos = player.getPosition().getX();
        int yPos = player.getPosition().getY();
        int tilePosX = xPos / gameViews.get(0).getWorldView().getTileSize();
        int tilePosY = yPos / gameViews.get(0).getWorldView().getTileSize();
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

        int nextTile = gameViews.get(0).getMapTileNum()[tilePosY][tilePosX];
        Tile tileToCheckCollide = new Tile(nextTile);
        return tileToCheckCollide.collide(player);
    }

    public void setGameViews(List<GameView> gameViews) {
        this.gameViews = gameViews;
    }
}