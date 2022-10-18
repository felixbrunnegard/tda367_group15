package com.TDA367group15.app;

import com.TDA367group15.app.model.Enemy;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EnemyTest {
    @Test
    public void testEnemyContractor(){
        Enemy enemy = new Enemy(221, 380);
        int posX = enemy.getPosition().getX();
        int posY = enemy.getPosition().getY();
        assertEquals(posX, 221 );
        assertEquals(posY, 380 );

    }
}
