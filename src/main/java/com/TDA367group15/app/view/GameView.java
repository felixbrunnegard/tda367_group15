package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.World;

import javax.swing.JPanel;
import java.awt.*;

public class GameView extends JPanel {
    public static final int SCREEN_WIDTH = 768;
    public static final int SCREEN_HEIGHT = 576;
    private SpriteView spriteView;

    private HPView hpView;
    private  XPView xpView;

    private final World world;
    private TileView tileView;

    private CombatView combatView;


    public GameView(World world){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setLayout(null);
        this.world = world;


        spriteView = new SpriteView(world.getPlayer(),world.getEnemies());
        hpView = new HPView(world.getPlayer());
        xpView = new XPView(world.getPlayer());
        tileView = new TileView(world.getPlayer());
        combatView = new CombatView(world.getPlayer(), world.getEnemies().get(0), SCREEN_WIDTH, SCREEN_HEIGHT);

        for (int i = 0; i < combatView.getAbilityButtons().size(); i++){
            this.add(combatView.getAbilityButtons().get(i));
        }

        combatView.setAbilityButtonsVisibility(false);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (world.isGameOver()){
            String text = "GAME OVER";
            setFont(g2, text);
            combatView.setAbilityButtonsVisibility(true);
        }

        else if (world.isVictory()){
            String text = "Victory!";
            setFont(g2, text);
        }
        else if(!world.isCombat()){
            combatView.setAbilityButtonsVisibility(false);
            tileView.draw(g2);
            spriteView.draw(g2);
            hpView.draw(g2);
            xpView.draw(g2);
        }
        else {
            combatView.draw(g2);
            combatView.setAbilityButtonsVisibility(true);
        }


    }

    private void setFont(Graphics2D g2, String text) {
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));

        int x = getXCordForCenteredText(g2,text);
        int y =  getYCordForCenteredText(g2, text);

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
    }

    public void update(){
        repaint();
    }

    public TileView getTileView(){
        return tileView;
    }

    public CombatView getCombatView(){
        return this.combatView;
    }

    public void setCombatView(Enemy enemyInCombat){
        combatView = new CombatView(world.getPlayer(), enemyInCombat, SCREEN_WIDTH, SCREEN_HEIGHT);

        for (int i = 0; i < combatView.getAbilityButtons().size(); i++){
            this.add(combatView.getAbilityButtons().get(i));
        }

        combatView.setAbilityButtonsVisibility(false);
    }

    private int getXCordForCenteredText(Graphics2D g2, String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return SCREEN_WIDTH/2 - length/2;
    }

    private int getYCordForCenteredText(Graphics2D g2, String text){
        int height = (int)g2.getFontMetrics().getStringBounds(text, g2).getHeight();
        return SCREEN_HEIGHT/2 + height/4;
    }


}
