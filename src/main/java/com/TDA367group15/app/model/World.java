package com.TDA367group15.app.model;

import java.util.List;

public class World implements IEnemyDeathListener{
    private Player player;
    private List<Enemy> enemies;
    private boolean combat;
    private boolean gameOver;
    private boolean victory;
    private Enemy enemyInCombat;

    public World(Player player, List<Enemy> enemies){
        this.player = player;
        this.enemies = enemies;
    }

    /**
     * Get the Worlds player
     * @return the world Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the Worlds enemies
     * @return list of enemies in the game world
     */    
    public List<Enemy> getEnemies() {
        return enemies;
    }

/**
     * Adds new enemy in the game world
     * @param enemy to be added to the world
     */
    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    /**
     * Adds new players in the game world
     * @param enemies list of enemies to be added to the world
     */
    public void addEnemies(List<Enemy> enemies){
        this.enemies.addAll(enemies);
    }

    /**
     * Removes enemy from the world. If the list becomes empty after the enemy is removed the method will sett game state to Victory.
     * @param enemy to be removed from world
     */
    public void removeEnemy(Enemy enemy){
        this.enemies.remove(enemy);

        if(this.enemies.isEmpty()){
            setVictory();
        }
    }

    /**
     * Get the current enemy in combat.
     * @return enemy in combat
     */
    public Enemy getEnemyInCombat(){
        return this.enemyInCombat;
    }

    /**
     * Get the current enemy in combat.
     * @param enemyInCombat the enemy to be set to combat
     */
    public void setEnemyInCombat(Enemy enemyInCombat){
        this.enemyInCombat = enemyInCombat;
    }

    //This will be fired of when whe have gone through thelisternes which this class is in combat.
    @Override
    public void enemyWasKilled(Enemy enemy){
        removeEnemy(enemy);
    }

    @Override
    public void fightOver() {
        toWorld();        
    }


    /**
     * Check if the game state is combat
     * @return flag if the game is in combat or not
     */
    public boolean isCombat() {
        return combat;
    }

    /**
     * Sets the game state to combat. Combat=true
     */
    public void toCombat() {
        this.combat = true;
    }

    /**
     * Sets the game state to world. Combat=false
     */
    public void toWorld() {
        this.combat = false;
    }

    /**
     * Checks if the game state is game over
     * @return Returns true if gameOver flag is true
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Sets game state as game over
     */
    public void setGameOver() {
        this.gameOver = true;
    }

    /**
     * Checks if the game is completed or not
     * @return Returns true if victory flag is true
     */
    public boolean isVictory() {
        return victory;
    }

    /**
     * Sets game as completed victoriously.
     */
    public void setVictory() {
        this.victory = true;
    }
}