package com.TDA367group15.app;
import com.TDA367group15.app.model.Direction;
import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testMoveRight(){
        Player player = new Player(42, 54);
        player.move(Direction.RIGHT);
        assertEquals(player.getPosition().getX(), 46 );
    }
    @Test
    public void testMoveLeft(){
        Player player = new Player(42, 54);
        player.move(Direction.LEFT);
        assertEquals(player.getPosition().getX(), 38 );
    }
    @Test
    public void testMoveUp(){
        Player player = new Player(42, 54);
        player.move(Direction.UP);
        assertEquals(player.getPosition().getY(), 50 );
    }
    @Test
    public void testMoveDown(){
        Player player = new Player(42, 54);
        player.move(Direction.DOWN);
        assertEquals(player.getPosition().getY(), 58 );
    }
    @Test
    public void testAttack(){
        Player player = new Player();
    }

    @Test
    public void testCollideWithEnemyTrue(){
        Enemy enemy = new Enemy(23,20);
        Player player = new Player(23, 15);
        player.collide(enemy);
        assertTrue(player.isCollideWithEnemies());

    }
    @Test
    public void testCollideWithEnemyFalse(){
        Enemy enemy = new Enemy(23,20);
        Player player = new Player(20, 15);
        player.collide(enemy);
        assertFalse(player.isCollideWithEnemies());

    }

    @Test
    public void testGenerateName(){
        Player player = new Player();
        assertEquals(player.getName(5).length(), 5);
    }




}
