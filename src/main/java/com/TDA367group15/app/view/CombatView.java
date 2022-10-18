package com.TDA367group15.app.view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CombatView {

    private BufferedImage image;
    private int width;
    private int height;

    public CombatView(int width, int height) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/combat.png"));
        } catch (Exception e){
            e.printStackTrace();
        }

        this.width = width;
        this.height = height;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(image, 0, 0, width, height, null);
    }
}
