package com.TDA367group15.app.model;

public class Player extends Combatable{
    private int xp;
    private int overWorldHealth;
    private int maxHealth = 1;


    public Player(){
        this(1488,960);
    }
    public Player(int x, int y){
        super(x, y);
        setMaxOverWorldHealth(6);
        setOverWorldHealth(5);
    }

    public int getOverWorldHealth() {
        return overWorldHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    protected void setOverWorldHealth(int health){
        this.overWorldHealth = health;
    }

    protected void setMaxOverWorldHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }

    public void ReduceOverWorldHealth(int damage) {
        overWorldHealth -= damage;
    }

    public void attack(Enemy e){

    }

    public int getLevel(){
        return 1;
    }

    public boolean willPlayerCollideWithEntityInCurrentDirection(Entity entity, Direction direction){
        if(collide(entity)){
            int xDiff = entity.getPosition().getX() - getPosition().getX();
            int yDiff = entity.getPosition().getY() - getPosition().getY();
            //Checks below so that it is still possible to walk away from the enemy
            if(xDiff < 0 && direction == Direction.LEFT){
                return true;
            }
            else if(xDiff > 0 && direction == Direction.RIGHT){
                return true;
            } else if(yDiff < 0 && direction == Direction.UP){
                return true;
            } else if(yDiff > 0 && direction == Direction.DOWN){
                return true;
            }
        }
        return false;

    }

}
