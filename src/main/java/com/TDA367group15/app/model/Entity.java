package com.TDA367group15.app.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public abstract class Entity {

    //current position for an entity
    private Position position;

    BufferedImage image;

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
        position = new Position(posX,posY);
    }

    public Position getPosition() {
        return position;
    }

    public void imageURL(String path) throws IOException {
        //image = ImageIO.read(getClass().getResourceAsStream(path));
        image = ImageIO.read(new File(path));
    }
    public BufferedImage getImage() {
        return image;
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
    public boolean collide(Entity otherEntity){

        Position otherPos = otherEntity.getPosition();
        Position thisPos = getPosition();

        int xDiff = otherPos.getX() - thisPos.getX();
        int yDiff = otherPos.getY() - thisPos.getY();
        if(xDiff <= SIZE && yDiff <= SIZE){
            return true;
        }
        return false;
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

    public String getName(){
        return generateName(5);
    }
}

