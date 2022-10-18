package com.TDA367group15.app.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combat {

      //Since player will not be present in code we need to tell the programm that a plyer will be presetn
    private boolean stop;
    public List<IEnemyDeathListener> listeners;

    public void combat(Combatable player, Combatable enemy, IEnemyDeathListener world){

        this.listeners = new ArrayList<>();

        Random rand = new Random();

        int upperbound = 25;
        int int_random =rand.nextInt(upperbound);

        addIEnemyDeathListener(world);
        fight(player, enemy);

    }


    // We also need to add World class to listerners. This is funky.
    public void addIEnemyDeathListener(IEnemyDeathListener listener){
        listeners.add(listener);
    }


    public void fight(Combatable player, Combatable enemy){

        stop = false;

        while (stop == false) {

            player.Attack(enemy);

            if (enemy.getHp() <= 0) {
                stop = true;
                playerWin(player, enemy);
                break;

            }

            enemy.Attack(player);

            if (player.getHp() < 0) {
                stop = true;
                enemyWin(player, enemy);
                break;
            }

        }

    }


    public void playerWin(Combatable player, Combatable enemy){

       // why do ypu calculate in this way? must you have float xp? are conflict.
       player.setXp((enemy.getLevel()/5) + player.getXp());

       player.setHp(player.getLevel()*100); //Resets hp

       //This should remove enemy from enemy list
       //Enemy should not interactable nor visable anymore

        for (IEnemyDeathListener listener : listeners){
            listener.enemyWasKilled((Enemy) enemy);
        }

    }


    public void enemyWin( Combatable player, Combatable enemy){

        //Reduce overworld health
    }

}




