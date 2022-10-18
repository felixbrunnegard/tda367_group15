package com.TDA367group15.app.view;

import java.awt.Graphics2D;

public abstract class WorldView {

    private final static int originalTileSize = 16;
    private final static int scale = 3;
    public final static int tileSize = originalTileSize * scale;

    private final int maxScreenColumn = 16;
    private final int maxScreenRow = 12;

    public abstract void draw(Graphics2D g2); //say to all others to hava draw method.
}
