package com.TDA367group15.app.model;

import com.TDA367group15.app.view.WorldView;

import java.util.Random;


public abstract class Entity implements ICollidable {

    //current position for an entity
    private Position position;

    private final static int MOVEMENT_SPEED = 2; //denpendcy injection för static variabel

    private Direction lookingDirection;  // direction player looks at

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

    /**
     * Moves the entity in the direction provided according to the set MOVEMENT_SPEED
     * @param d Direction to move in
     */
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
     * Calculates if this entity collides (overlap) with another
     * @param otherEntity Entity check collision with
     * @return True if entities overlap
     */
    @Override
    public boolean collide(Entity otherEntity){

        Position otherPos = otherEntity.getPosition();
        Position thisPos = getPosition();

        int xDiff = otherPos.getX()- thisPos.getX();
        int yDiff = otherPos.getY() -thisPos.getY();

        if(Math.abs(xDiff) <= 48 && Math.abs(yDiff) <= 48){
            return true;
        }
        return false;
    }

    /**
     * Generates a random string with the length provided
     * Only contains characters:
     * 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&
     *
     * @param len length of the string to generate
     * @return randomized string
     */
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

