package com.TDA367group15.app;

import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.World;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WorldTest {
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private World world;


    @Test
    public void TestGetPlayerValid(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        enemies.add(new Enemy(2,3));
        enemies.add(new Enemy(4,5));
        enemies.add(new Enemy(6,7));
        world = new World(player, enemies);
        assertEquals(player, world.getPlayer());
    }

    @Test
    public void TestGetEnemiesValid(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        enemies.add(new Enemy(2,3));
        enemies.add(new Enemy(4,5));
        enemies.add(new Enemy(6,7));
        world = new World(player, enemies);
        assertEquals(enemies.size(), world.getEnemies().size());
    }

    @Test
    public void TestAddEnemyValid(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        enemies.add(new Enemy(2,3));
        enemies.add(new Enemy(4,5));
        enemies.add(new Enemy(6,7));
        world = new World(player, enemies);
        world.addEnemy(new Enemy(8,9));
        assertEquals(enemies.size(), world.getEnemies().size());
        assertEquals(8, world.getEnemies().get(enemies.size()-1).getPosition().getX());
        assertEquals(9, world.getEnemies().get(enemies.size()-1).getPosition().getY());
    }

    @Test
    public void TestAddEnemiesValid(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        enemies.add(new Enemy(2,3));
        enemies.add(new Enemy(4,5));
        enemies.add(new Enemy(6,7));
        world = new World(player, enemies);
        List<Enemy> newEnemies = new ArrayList<>();
        newEnemies.add(new Enemy(8,9));
        newEnemies.add(new Enemy(10,11));
        world.addEnemies(newEnemies);

        assertEquals(8, world.getEnemies().get(enemies.size()-2).getPosition().getX());
        assertEquals(9, world.getEnemies().get(enemies.size()-2).getPosition().getY());
        assertEquals(10, world.getEnemies().get(enemies.size()-1).getPosition().getX());
        assertEquals(11, world.getEnemies().get(enemies.size()-1).getPosition().getY());
    }

    @Test
    public void TestRemoveValid(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        enemies.add(new Enemy(2,3));
        enemies.add(new Enemy(4,5));
        enemies.add(new Enemy(6,7));
        world = new World(player, enemies);
        world.removeEnemy(enemies.get(0));

        assertEquals(2, world.getEnemies().get(0).getPosition().getX());
        assertEquals(3, world.getEnemies().get(0).getPosition().getY());
        assertEquals(3, world.getEnemies().size());
    }

    @Test
    public void TestIsCombatFalseValid(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        enemies.add(new Enemy(2,3));
        enemies.add(new Enemy(4,5));
        enemies.add(new Enemy(6,7));
        world = new World(player, enemies);

        assertFalse(world.isCombat());
    }

    @Test
    public void TestIsCombatTrueValid(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        enemies.add(new Enemy(2,3));
        enemies.add(new Enemy(4,5));
        enemies.add(new Enemy(6,7));
        world = new World(player, enemies);
        world.toCombat();

        assertTrue(world.isCombat());
    }

    @Test
    public void TestIsCombatFalseWorldValid(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        enemies.add(new Enemy(2,3));
        enemies.add(new Enemy(4,5));
        enemies.add(new Enemy(6,7));
        world = new World(player, enemies);
        world.toCombat();
        world.toWorld();

        assertFalse(world.isCombat());
    }

    @Test
    public void TestIsGameOver(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        world = new World(player, enemies);
        world.removeEnemy(enemies.get(0));

        assertTrue(world.isGameOver());
    }

    @Test
    public void TestIsNotGameOver(){
        player = new Player();
        enemies.add(new Enemy(1,2));
        world = new World(player, enemies);

        assertFalse(world.isGameOver());
    }
}
