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

/**
 * The combat view that will be rendered in the main {@link GameView} object when a player gets into combat.
 */
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

    /**
     * Constructs the main combat view object with a {@link Player} object and a {@link Enemy} object
     * that will be present in combat.
     * @param player The player that will be in combat.
     * @param enemy The enemy that will be in combat.
     * @param width The width of the window.
     * @param height The height of the window.
     */
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

    /**
     * The main draw method of the combat view object which renders the background of the fighting scene and
     * the HP boxes of the player and enemy.
     * @param g2
     */
    public void draw(Graphics2D g2){
        g2.drawImage(image, 0, 0, width, height, null);
        combatHPView.draw(g2);
    }

    /**
     * Adds the buttons that the player will use to fight to a List and calls other methods to customise the buttons.
     */
    public void setAbilityButtons(){
        abilityButtons.add(firstAbility);
        abilityButtons.add(secondAbility);
        abilityButtons.add(thirdAbility);
        abilityButtons.add(fourthAbility);

        setAbilityButtonsName();
        setAbilityButtonsPosition();
        setAbilityButtonsDesign();

    }

    /**
     * Sets the text to be displayed on the buttons to the ability names of the player.
     */
    public void setAbilityButtonsName(){
        for (int i = 0; i < abilityButtons.size(); i++){
            abilityButtons.get(i).setFont(new Font("Arial", Font.PLAIN, 18));
            abilityButtons.get(i).setText(player.getAbilities().get(i).getName());
        }
    }

    /**
     * Sets where the buttons should be placed on the screen.
     */
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

    /**
     * Sets the design of the buttons.
     */
    public void setAbilityButtonsDesign(){
        for (int i = 0; i < abilityButtons.size(); i++){
            abilityButtons.get(i).setFocusable(false);
            abilityButtons.get(i).setBackground(Color.WHITE);
            abilityButtons.get(i).setBorder(new LineBorder(Color.BLACK));
            abilityButtons.get(i).setFocusPainted(false);
        }
    }

    /**
     * Returns the list of the buttons.
     * @return A list of buttons.
     */
    public List<JButton> getAbilityButtons(){
        return abilityButtons;
    }

    /**
     * Sets whether the buttons should be visible on screen.
     * @param visibility A boolean true or false to specify if the buttons should show or not.
     */
    public void setAbilityButtonsVisibility(boolean visibility){
        for (int i = 0; i < getAbilityButtons().size(); i++){
            getAbilityButtons().get(i).setVisible(visibility);
        }
    }

}
