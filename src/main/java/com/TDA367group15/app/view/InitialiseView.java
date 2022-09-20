package com.TDA367group15.app.view;

import javax.swing.*;

public class InitialiseView {
    JFrame window = new JFrame();

    public InitialiseView(GameView gameView){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Blue Boy Adventure");
        window.add(gameView);
        window.setLocationRelativeTo(null);
        window.pack();
        window.setVisible(true);
    }
}
