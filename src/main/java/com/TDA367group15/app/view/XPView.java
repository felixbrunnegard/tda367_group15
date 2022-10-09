package com.TDA367group15.app.view;

import com.TDA367group15.app.model.GameLoop;
import com.TDA367group15.app.model.Player;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class XPView extends HUDView {
    private Player player;
    public XPView(Player player){
        this.player = player;
    }
    @Override
    public void draw(Graphics2D g2) {
        drawRoundRectangleEdge(g2);
        drawRoundRectangleBackground(g2);
        drawRoundRectangleXP(g2);
        drawLevel(g2);

    }

    private static void drawRoundRectangleEdge(Graphics2D g2) {
        RoundRectangle2D roundRectangle2D = new RoundRectangle2D.Float(GameView.SCREEN_WIDTH / 2 - 152, 8, 304, 24, 25, 25);

        g2.setColor(Color.ORANGE);
        g2.fill(roundRectangle2D);
        g2.draw(roundRectangle2D);
    }
    private static void drawRoundRectangleBackground(Graphics2D g2) {
        RoundRectangle2D roundRectangle2D1 = new RoundRectangle2D.Float(GameView.SCREEN_WIDTH / 2 - 150, 10, 300, 20, 25, 25);

        g2.setColor(Color.BLACK);
        g2.fill(roundRectangle2D1);
        g2.draw(roundRectangle2D1);
    }
    private static void drawRoundRectangleXP(Graphics2D g2) {
        RoundRectangle2D roundRectangle2D2 = new RoundRectangle2D.Float(GameView.SCREEN_WIDTH / 2 - 100, 10, 250, 20, 25, 25);

        g2.setColor(Color.BLUE);
        g2.fill(roundRectangle2D2);
        g2.draw(roundRectangle2D2);
    }

    private void drawLevel(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.drawString("LV"+ player.getLevel(), GameView.SCREEN_WIDTH/2 + 120, 25);
    }
}
