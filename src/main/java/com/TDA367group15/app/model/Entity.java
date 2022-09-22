package com.TDA367group15.app.model;

import java.awt.image.BufferedImage;

public abstract class Entity {
    // TODO: Do vi need name for entities?
    private String name;

    //current position for an entity
    private Vector2 position;

    private BufferedImage image;

    private final static int MOVEMENT_SPEED = 4;

    //TODO: Do we need size of entity or width and height
    private final static int SIZE = 1;

    //TODO: CHECK WHY WE WILL USE position class
//    private Position position;
    private Direction lookingDirection;  // direction player looks at

    // entity starts at position 0 or a certain position
    public Entity(){
        this(0, 0);
    }

    public Entity(int posX, int posY){
        position = new Vector2(posX,posY);
    }

    public Vector2 getPosition() {
        return position;
    }

    //TODO: one method instead of 4 as described in uml?
    public void move(Direction d){
        if (d == Direction.UP){
            position.moveY(-MOVEMENT_SPEED);
        }
        else if (d == Direction.DOWN){
            position.moveY(MOVEMENT_SPEED);
        }
        else if (d == Direction.LEfT){
            position.moveX(-MOVEMENT_SPEED);
        }
        else if (d == Direction.RIGHT){
            position.moveX(MOVEMENT_SPEED);
        }

    }

    /**
     * Calculates if this entity collides with another
     */
    public boolean collide(Entity otherEntity){

        Vector2 otherPos = otherEntity.getPosition();
        Vector2 thisPos = getPosition();

        int xDiff = otherPos.getX() - thisPos.getX();
        int yDiff = otherPos.getY() - thisPos.getY();
        if(xDiff <= SIZE && yDiff <= SIZE){
            return true;
        }
        return false;
    }

}

