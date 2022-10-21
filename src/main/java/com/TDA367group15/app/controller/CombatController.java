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

    public CombatController(CombatView combatView){
        this.combatView = combatView;

        setCombatButtons();
        setButtonsAction();
    }

    public void setCombatButtons(){
        abilityButtons = combatView.getAbilityButtons();

        firstButton = abilityButtons.get(0);
        secondButton = abilityButtons.get(1);
        thirdButton = abilityButtons.get(2);
        fourthButton = abilityButtons.get(3);
    }

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

    public void initiateTurn(int chosenAbility){
        combat.fight(player, enemy, chosenAbility);
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    public void setCombat(Combat combat){
        this.combat = combat;
    }

    public void setCombatView(CombatView combatView){
        this.combatView = combatView;
    }

}
