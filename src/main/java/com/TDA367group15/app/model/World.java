package com.TDA367group15.app.model;

import java.util.List;

public class World {
    // only one instance, everyone shares it.
    private Player player;
    private List<Enemy> enemies;
    private boolean combat;
    private boolean gameOver;

    public World(Player player, List<Enemy> enemies){
        this.player = player;
        this.enemies = enemies;
    }

    public Player getPlayer() {
        return player;
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
            setGameOver();
        }
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
}