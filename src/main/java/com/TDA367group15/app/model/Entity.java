package com.TDA367group15.app.model;

import java.util.Random;


public abstract class Entity implements ICollidable {

    //current position for an entity
    private Position position;

    public final static int MOVEMENT_SPEED = 2; //denpendcy injection för static variabel

    //TODO: Do we need size of entity or width and height

    private Direction lookingDirection;  // direction player looks at
    private boolean collideWithEnemies;

    // entity starts at position 0 or a certain position
    public Entity(){
        this(0, 0);
    }


    public Entity(int posX, int posY){
        position = new Position(posX,posY);
    }


    public Position getPosition() {
        return position;
    }


    public boolean isCollideWithEnemies() {
        return collideWithEnemies;
    }


    //TODO: one method instead of 4 as described in uml?
    public void move(Direction d){
        if (d == Direction.UP){
            position.moveY(-MOVEMENT_SPEED);
        }
        else if (d == Direction.DOWN){
            position.moveY(MOVEMENT_SPEED);
        }
        else if (d == Direction.LEFT){
            position.moveX(-MOVEMENT_SPEED);
        }
        else if (d == Direction.RIGHT){
            position.moveX(MOVEMENT_SPEED);
        }

    }


    /**
     * Calculates if this entity collides with another
     */
    @Override
    public boolean collide(Entity otherEntity){

        Position otherPos = otherEntity.getPosition();
        Position thisPos = getPosition();

        int xDiff = otherPos.getX() - thisPos.getX();
        int yDiff = otherPos.getY() - thisPos.getY();
        if(xDiff <= 0 || yDiff <= 0){
            return collideWithEnemies = true;
        }
        return collideWithEnemies = false;
    }


    public static String generateName(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }


    public String getName(int a){
        return generateName(a);
    }
}

