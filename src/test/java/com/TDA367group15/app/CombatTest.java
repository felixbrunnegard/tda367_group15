package com.TDA367group15.app;

import com.TDA367group15.app.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.*;

public class CombatTest {

    private Player player;
    private World world;
    private Enemy enemy;
    private List<Enemy> enemies;


    @Test
    public void TestHpLoss(){

        player = new Player();
        enemy = new Enemy(1, 1);
        List<Enemy> enemies1 = new ArrayList<>();
        enemies1.add(enemy = new Enemy(1, 1));
        world = new World(player, enemies1 );

        Combat combat = new Combat(world);

        combat.fight(player, enemy, 1);

        assertFalse(enemy.getHp() == player.getHp());

    }


    @Test
    public void TestXPGained(){

        player = new Player();
        enemy = new Enemy(1, 1);
        List<Enemy> enemies1 = new ArrayList<>();
        enemies1.add(enemy = new Enemy(1, 1));
        world = new World(player, enemies1 );
        Combat combat = new Combat(world);

        while (enemy.getHp()>=0){
            combat.fight(player, enemy, 1);
        }

        assertTrue(player.getXp()>0);

    }

    @Test
    public void HpScalesWithLevel (){

        player = new Player();
        enemy = new Enemy(1, 1);
        List<Enemy> enemies1 = new ArrayList<>();
        enemies1.add(enemy = new Enemy(1, 1));
        world = new World(player, enemies1 );
        Combat combat = new Combat(world);


        while (enemy.getHp()>=0){
            combat.fight(player, enemy, 1);
        }

       assertTrue(player.getAbilities().get(1).calculateAttack(player.getLevel()) == 2.0 * 20.0);


    }

}
