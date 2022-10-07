package com.TDA367group15.app.controller;

import com.TDA367group15.app.model.Direction;
import com.TDA367group15.app.model.Player;


public class PlayerController {

    Player player;


    public PlayerController(Player player) {
        this.player = player;
    }

    
    public void actOnMovement(Direction direction) {
        player.move(direction);
    }

}
