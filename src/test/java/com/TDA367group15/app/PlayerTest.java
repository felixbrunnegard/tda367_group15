package com.TDA367group15.app;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.Vector2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void testMoveRight(){
        Player player = new Player();
        Vector2 position = player.getPosition();
        position.moveX(5);
        assertEquals(player.getPosition().getX(), position.getX() + 5 );
    }
    @Test
    public void testMoveLeft(){
        Player player = new Player();
        Vector2 position = player.getPosition();
        position.moveX(5);
        assertEquals(player.getPosition().getX(), position.getX() - 5 );
    }
    @Test
    public void testMoveUp(){
        Player player = new Player();
        Vector2 position = player.getPosition();
        position.moveY(5);
        assertEquals(player.getPosition().getY(), position.getY() + 5 );
    }
    @Test
    public void testMoveDown(){
        Player player = new Player();
        Vector2 position = player.getPosition();
        position.moveY(5);
        assertEquals(player.getPosition().getY(), position.getY() - 5 );
    }
    @Test
    public void testAttack(){
        Player player = new Player();
    }


}
