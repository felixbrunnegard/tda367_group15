package com.TDA367group15.app.model;
import java.util.Random;

public class Combat {

    private Player player;  //Since player will not be present in code we need to tell the programm that a plyer will be presetn
    private boolean stop;


    public void combat(Combatable player, Combatable enemy){



        Random rand = new Random();

        int upperbound = 25;
        int int_random =rand.nextInt(upperbound);

        fight(player, enemy);

    }

    
    public void fight(Combatable player, Combatable enemy){

        stop = false;

        while (stop == false) {

            player.Attack(enemy);

            if (enemy.getHp() <= 0) {
                stop = true;
                playerWin(enemy);
                break;

            }

            enemy.Attack(player);

            if (player.getHp() < 0) {
                stop = true;
                enemyWin();
                break;
            }

        }

    }


    public void playerWin(Combatable enemy){

       player.setLevel(enemy.getLevel()/5 + player.getLevel());

       //This should remove enemy from enemy list
       //Enemy should not interactable nor visable anymore

    }


    public void enemyWin(){

       // This should subtract one heart from global player hearts.

    }


}




