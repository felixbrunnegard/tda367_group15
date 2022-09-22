package com.TDA367group15.app.view;

import java.awt.*;

public abstract class WorldView {

    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;

    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;

    public void draw(Graphics2D g2){
    }
}
