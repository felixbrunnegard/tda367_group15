package com.TDA367group15.app.model;

import java.util.List;

public class World implements IEnemyDeathListener{
    // only one instance, everyone shares it.
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public void addEnemies(List<Enemy> enemies){
        this.enemies.addAll(enemies);
    }

    //If enemy list is empty the game is won
    public void removeEnemy(Enemy enemy){
        this.enemies.remove(enemy);

        if(this.enemies.isEmpty()){
            setVictory();
        }
    }

    public Enemy getEnemyInCombat(){
        return this.enemyInCombat;
    }

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


    public boolean isCombat() {
        return combat;
    }

    public void toCombat() {
        this.combat = true;
    }

    public void toWorld() {
        this.combat = false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver() {
        this.gameOver = true;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory() {
        this.victory = true;
    }
}