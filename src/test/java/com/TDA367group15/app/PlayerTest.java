package com.TDA367group15.app;
import com.TDA367group15.app.model.Direction;

import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerTest {
    @Test
    public void testMoveRight(){
        Player player = new Player(42, 54);
        player.move(Direction.RIGHT);
        assertEquals(player.getPosition().getX(), 44 );
    }
    @Test
    public void testMoveLeft(){
        Player player = new Player(42, 54);
        player.move(Direction.LEFT);
        assertEquals(player.getPosition().getX(), 40);
    }
    @Test
    public void testMoveUp(){
        Player player = new Player(42, 54);
        player.move(Direction.UP);
        assertEquals(player.getPosition().getY(), 52 );
    }
    @Test
    public void testMoveDown(){
        Player player = new Player(42, 54);
        player.move(Direction.DOWN);
        assertEquals(player.getPosition().getY(), 56 );
    }

    @Test
    public void testGenerateName(){
        Player player = new Player();
        assertEquals(player.getName(5).length(), 5);
    }

    @Test
    public void TestReduceOverWorldHealth(){
        Player player = new Player();
        player.ReduceOverWorldHealth(1);
        assertEquals(player.getOverWorldHealth(), 4);
    }
    @Test
    public void TestGetMaxHealth(){
        Player player = new Player();
        assertEquals(player.getOverWorldHealth(), 6);
    }

    @Test
    public void TestGetLevel(){
        Player player = new Player();
        assertEquals(player.getLevel(), 1);
    }

    @Test
    public void TestCollideWithEnemyTrue(){
        Player player = new Player(321, 290);
        Enemy enemy = new Enemy(320, 288);
        assertTrue( player.collide(enemy));
    }

    @Test
    public void TestCollideWithEnemyFalse(){
        Player player = new Player(690, 320);
        Enemy enemy = new Enemy(320, 288);
        assertFalse( player.collide(enemy));
    }

}
