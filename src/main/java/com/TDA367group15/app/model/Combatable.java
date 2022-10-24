package com.TDA367group15.app.model;
import java.util.ArrayList;
import java.util.List;


public abstract class Combatable extends Entity{

    private float hp;
    private int level;
    private int xp;

    // The following arraylist is the list of instances of the class ability.
    // The arraylist contains all the abilities each respective Combatable is to be able to use
    private List<Ability> abilities = new ArrayList<>();

    public Combatable(){
        super();
    }
    public Combatable(int x, int y) {
        super(x, y);

        level = 1;
        hp = 100*level;
    }

    public float getMaxHP(){return 100*level;}

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

    /**
     * This method subtracts the hp of the combatable entity that is given as an argument.
     * @param enemyOrPlayer
     * @param chosenAbility
     */
    public void Attack(Combatable enemyOrPlayer, int chosenAbility){

        float newHp = 0;

        newHp = enemyOrPlayer.getHp() - abilities.get(chosenAbility).calculateAttack(level);

        enemyOrPlayer.setHp(newHp);

    }


}
