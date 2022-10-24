package com.TDA367group15.app.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Combat {

    private List<IEnemyDeathListener> listeners;

    public Combat(IEnemyDeathListener world){

        this.listeners = new ArrayList<>();

        Random rand = new Random();

        int upperbound = 25;
        int int_random =rand.nextInt(upperbound);

        addIEnemyDeathListener(world);

    }

    public void addIEnemyDeathListener(IEnemyDeathListener listener){
        listeners.add(listener);
    }

    /**
     * The fight method is in effect a turn where both player and enemy attacks
     * each other using either a random ability in the case of enemy or for player an ability
     * chosen by the user of the program.
     *
     * @param player
     * @param enemy
     * @param chosenAbility
     */
    public void fight(Player player, Enemy enemy, int chosenAbility){

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


    /**
     *
     * This method awards the player with xp relating to the level of the enemy defeated.
     * It later restes the local combat hp for the player so that palyer has full hp for the next fight.
     *
     * @param player
     * @param enemy
     */

    public void playerWin(Combatable player, Combatable enemy){

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




