package com.TDA367group15.app.model;

public class Ability {

    float attackPower;
    float defencePower;
    float accuracy;
    String name;

    public Ability(String name, float attackPower, float defencePower, float accuracy) {
        this.name = name;
        this.attackPower = attackPower;
        this.defencePower = defencePower;
        this.accuracy = accuracy;
    }


    public String getName(){
        return name;
    }


    /**
     * This method calculates the attack points to later subtract.
     * @param level
     * @return
     */
    public float calculateAttack(int level){

        float attackPoints = 0;
        attackPoints = this.attackPower * level;

        return attackPoints;
    }

}
