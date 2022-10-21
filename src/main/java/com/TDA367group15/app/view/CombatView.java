package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CombatView {

    private BufferedImage image;
    private int width;
    private int height;
    private CombatHPView combatHPView;
    private Player player;

    private JButton firstAbility = new JButton();
    private JButton secondAbility = new JButton();
    private JButton thirdAbility = new JButton();
    private JButton fourthAbility = new JButton();

    private List<JButton> abilityButtons = new ArrayList<>();

    private int buttonWidth = 150;
    private int buttonHeight = 80;
    private int abilityButtonsPosX = 400;
    private int abilityButtonsPosY = 400;

    public CombatView(Player player, Enemy enemy, int width, int height) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/combat.png"));
        } catch (Exception e){
            e.printStackTrace();
        }

        this.width = width;
        this.height = height;
        this.player = player;
        this.combatHPView = new CombatHPView(player, enemy, width, height);
        setAbilityButtons();
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, 0, 0, width, height, null);
        combatHPView.draw(g2);
    }

    public void setAbilityButtons(){
        abilityButtons.add(firstAbility);
        abilityButtons.add(secondAbility);
        abilityButtons.add(thirdAbility);
        abilityButtons.add(fourthAbility);

        setAbilityButtonsName();
        setAbilityButtonsPosition();
        setAbilityButtonsDesign();

    }

    public void setAbilityButtonsName(){
        for (int i = 0; i < abilityButtons.size(); i++){
            abilityButtons.get(i).setFont(new Font("Arial", Font.PLAIN, 18));
            abilityButtons.get(i).setText(player.getAbilities().get(i).getName());
        }
    }

    public void setAbilityButtonsPosition(){
        int xPos = 0;

        for (int i = 0; i < abilityButtons.size(); i++){
            if (xPos < 2) {
                abilityButtons.get(i).setBounds(abilityButtonsPosX + (xPos * buttonWidth), abilityButtonsPosY, buttonWidth, buttonHeight);
            }
            else {
                abilityButtons.get(i).setBounds( abilityButtonsPosX + ((xPos-2) * buttonWidth), abilityButtonsPosY + buttonHeight, buttonWidth, buttonHeight);
            }
            xPos++;
        }
    }

    public void setAbilityButtonsDesign(){
        for (int i = 0; i < abilityButtons.size(); i++){
            abilityButtons.get(i).setFocusable(false);
            abilityButtons.get(i).setBackground(Color.WHITE);
            abilityButtons.get(i).setBorder(new LineBorder(Color.BLACK));
            abilityButtons.get(i).setFocusPainted(false);
        }
    }

    public List<JButton> getAbilityButtons(){
        return abilityButtons;
    }

    public void setAbilityButtonsVisibility(boolean visibility){
        for (int i = 0; i < getAbilityButtons().size(); i++){
            getAbilityButtons().get(i).setVisible(visibility);
        }
    }

}
