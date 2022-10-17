package com.TDA367group15.app.model;

import com.TDA367group15.app.view.WorldView;

import java.util.ArrayList;
import java.util.List;

public class World {
    // only one instance, everyone shares it.
    private Player player;
    private List<Enemy> enemies;

    public World(Player player){
        this.player = player;
        this.enemies = new ArrayList<>();
        this.enemies.add(new Enemy(21* WorldView.tileSize, 380));
        this.enemies.add(new Enemy(15*WorldView.tileSize, 900));
        this.enemies.add(new Enemy(32*WorldView.tileSize, 580));
        this.enemies.add(new Enemy(221, 39*WorldView.tileSize));
        this.enemies.add(new Enemy(56*WorldView.tileSize, 750));
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
            System.out.println("You won!");
        }
    }
}