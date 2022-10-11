package com.TDA367group15.app.view;

import java.awt.*;

public abstract class WorldView {

    final static int originalTileSize = 16;
    final static int scale = 3;
    public final static int tileSize = originalTileSize * scale;

    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;

    public abstract void draw(Graphics2D g2); //say to all others to hava draw method.
}
