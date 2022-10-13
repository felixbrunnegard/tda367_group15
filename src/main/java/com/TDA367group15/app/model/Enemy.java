package com.TDA367group15.app.model;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends Combatable {

    private int pointerP;

    public Enemy(Integer randomPosX,Integer randomPosY ){
        super(randomPosX,randomPosY);

        //This creates a copy of the abilitylist in combatable then adds abilites to it then sets the list in combatible to the new lsit.

        ArrayList<Ability> newAbilityList = new ArrayList<Ability>(getAbilities());

        newAbilityList.add(new Ability("clawAttack", 10, 0, 90));
        newAbilityList.add(new Ability("Bite", 20, 0, 60));
        newAbilityList.add(new Ability("dodge", 0, 15, 95));
        newAbilityList.add(new Ability("pounces", 15, 0, 70));

        setAbilities(newAbilityList);

    }

    @Override
    public boolean collide(Entity player) {

        return false;
    }

    public void name(){}
    public void setAbility(){}
    public void setLevel(){}
    public void addAbility(){

    }

}
