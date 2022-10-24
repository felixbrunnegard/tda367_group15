package com.TDA367group15.app.controller;

import com.TDA367group15.app.model.Combat;
import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.view.CombatHPView;
import com.TDA367group15.app.view.CombatView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * {@code CombatController} is the controller for the buttons in the {@link CombatView}
 * class, which adds an action for each of the buttons.
 */
public class CombatController {
    private CombatView combatView;
    private Player player;
    private Enemy enemy;
    private Combat combat;
    private JButton firstButton;
    private JButton secondButton;
    private JButton thirdButton;
    private JButton fourthButton;

    private List<JButton> abilityButtons = new ArrayList<>();

    /**
     * Constructs a controller object to add functionality to the buttons in {@link CombatView}.
     * @param combatView The view class that contains the buttons.
     */
    public CombatController(CombatView combatView){
        this.combatView = combatView;

        setCombatButtons();
        setButtonsAction();
    }

    /**
     * Assigns the buttons in {@link CombatView} to the fields in this object.
     */
    public void setCombatButtons(){
        abilityButtons = combatView.getAbilityButtons();

        firstButton = abilityButtons.get(0);
        secondButton = abilityButtons.get(1);
        thirdButton = abilityButtons.get(2);
        fourthButton = abilityButtons.get(3);
    }

    /**
     * Adds ActionListeners to each button which specifies the method to be called when
     * a button is pressed.
     */
    public void setButtonsAction(){
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiateTurn(0);
            }
        });

        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiateTurn(1);
            }
        });

        thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiateTurn(2);
            }
        });

        fourthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initiateTurn(3);
            }
        });
    }

    /**
     * Calls the fight method in the {@link Combat} object to initiate a turn in the
     * turn-based combat system.
     * @param chosenAbility The value of the button pressed which is an integer in the interval 0-3.
     */
    public void initiateTurn(int chosenAbility){
        combat.fight(player, enemy, chosenAbility);
    }

    /**
     * Sets the player field in the current object to a specified {@link Player} object.
     * @param player The player object in the combat.
     */
    public void setPlayer(Player player){
        this.player = player;
    }

    /**
     * Sets the enemy field in the current object to a specified {@link Enemy} object.
     * @param enemy The enemy object in the combat.
     */
    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    /**
     * Sets the combat field in the current object to a specified {@link Combat} object.
     * @param combat The current combat object.
     */
    public void setCombat(Combat combat){
        this.combat = combat;
    }

    /**
     * Sets the combatView field in the current object to the {@link CombatView} that is currently displayed.
     * @param combatView The current combat view that is rendering.
     */
    public void setCombatView(CombatView combatView){
        this.combatView = combatView;
    }

}
