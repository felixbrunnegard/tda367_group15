package com.TDA367group15.app.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Combatable extends Entity{

    private float hp;
    private int level;
    private int xp;
    private Enemy enemy;
    private Player player;

    //Make an array with ability objects.
    private List<Ability> abilities = new ArrayList<>();

    public Combatable(){
        super();
    }
    public Combatable(int x, int y) {
        super(x, y);

        level = 1;
        hp = 100*level;
    }

    public float getHp(){ return hp; }
    public void setHp(float hp){this.hp = hp;}

    public int getLevel(){return level;}
    public void setLevel(int level) {this.level = level;}

    public int getXp() {return xp;}
    public void setXp(int xp) {this.xp = xp;}

    public List<Ability> getAbilities() {return abilities;}


    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }


    public float calculateAttack(Ability ability){

        float attackPoints = 0;
        attackPoints = ability.attackPower * level;

        return attackPoints;
    }


    public int chooseAbility(){

        //Get input from player as to which ability in the hashmap they would like to choose.
        int input = 0; //This will be the input form the player

        return input;
    }


    public int chooseRandomAbility(){

        Random randomInteger = new Random();
        int randomAbilityIndex = randomInteger.nextInt();

        return randomAbilityIndex;
    }


    public void Attack(Combatable enemyOrPlayer){

        float newHp = 0;

        if (enemyOrPlayer == player){
            newHp = enemyOrPlayer.getHp() - calculateAttack(abilities.get(chooseAbility()));
        }else {
            newHp = enemyOrPlayer.getHp() - calculateAttack(abilities.get(chooseRandomAbility()));
        }

        enemyOrPlayer.setHp(newHp);

    }


}
