package com.TDA367group15.app.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combat {

      //Since player will not be present in code we need to tell the programm that a plyer will be presetn
    private List<IEnemyDeathListener> listeners;

    public Combat(IEnemyDeathListener world){

        this.listeners = new ArrayList<>();

        Random rand = new Random();

        int upperbound = 25;
        int int_random =rand.nextInt(upperbound);

        addIEnemyDeathListener(world);


    }


    // We also need to add World class to listerners. This is funky.
    public void addIEnemyDeathListener(IEnemyDeathListener listener){
        listeners.add(listener);
    }


    public void fight(Player player, Combatable enemy, int chosenAbility){

        player.Attack(enemy, chosenAbility);

        if (enemy.getHp() <= 0) {
            playerWin(player, enemy);
        }

        else {

            enemy.Attack(player, enemy.chooseRandomAbility());

            if (player.getHp() < 0) {
                enemyWin(player, enemy);

            }

        }
    }


    public void playerWin(Combatable player, Combatable enemy){

       // why do ypu calculate in this way? must you have float xp? are conflict.
       player.setXp((enemy.getLevel()*100) + player.getXp());

       player.setHp(player.getLevel()*100); //Resets hp

       //This should remove enemy from enemy list
       //Enemy should not interactable nor visible anymore

        for (IEnemyDeathListener listener : listeners){
            listener.enemyWasKilled((Enemy) enemy);
        }

        listeners.get(0).fightOver();

    }


    public void enemyWin(Player player, Combatable enemy){

        player.ReduceOverWorldHealth(1);
        enemy.setHp(100 * enemy.getLevel());
        player.setHp(100 * player.getLevel());
        listeners.get(0).fightOver();

    }

}




