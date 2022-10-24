package com.TDA367group15.app.model;

import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Combatable {
    private int pointerP;

    public Enemy(Integer posX, Integer posY) {
        super(posX,posY);

        /**
         * This creates a new ability list in and then overwrites the old presumably empty list with this list.
         * This is done so if the previous list was something should not be this will change it completely
         * which is preferable seeing as the abilities' enemy starts of with should always be absolute.
         * */
        ArrayList<Ability> newAbilityList = new ArrayList<Ability>(getAbilities());

        newAbilityList.add(new Ability("clawAttack", 10, 0, 90));
        newAbilityList.add(new Ability("Bite", 20, 0, 60));
        newAbilityList.add(new Ability("dodge", 0, 15, 95));
        newAbilityList.add(new Ability("pounces", 15, 0, 70));

        setAbilities(newAbilityList);

    }

    public int chooseRandomAbility(){

        Random randomInteger = new Random();
        int randomAbilityIndex = randomInteger.nextInt(4);

        return randomAbilityIndex;
    }

    public void name(){}
    public void setAbility(){}
    public void setLevel(){}
    public void addAbility(){

    }

}
