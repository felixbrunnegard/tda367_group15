package com.TDA367group15.app.model;

import java.util.List;

public class World {
    // only one instance, everyone shares it.
    private Player player;
    private List<Enemy> enemies;

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

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
}