package com.TDA367group15.app.controller;

import com.TDA367group15.app.model.Direction;
import com.TDA367group15.app.model.Player;


/**
 * PlayerController is a class used to dictate what the player should do under various circumstances.
 * It is created using the already instantiated player which is to be controlled.
 */
public class PlayerController {

    private Player player;


    /**
     * Constructs and returns a PlayerController.
     * @param player the player to control.
     */
    public PlayerController(Player player) {
        this.player = player;
    }


    /**
     * Moves the character in the appropriate direction.
     * @param direction the direction in which the player should move.
     */
    public void actOnMovement(Direction direction) {
        player.move(direction);
    }

}
