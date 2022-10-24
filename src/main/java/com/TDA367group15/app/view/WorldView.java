package com.TDA367group15.app.view;

import com.TDA367group15.app.model.World;

import java.awt.Graphics2D;

/**
 * The main world view class that specifies the size of the tiles and constructs all different world view such
 * as {@link TileView}, {@link SpriteView}, {@link HPView} and {@link XPView}.
 */
public class WorldView {

    private final int originalTileSize = 16;
    private int scale = 3;
    private int tileSize = originalTileSize * scale;
    private int screenWidth;
    private int screenHeight;
    private int[][] mapTileNum;

    private SpriteView spriteView;
    private HPView hpView;
    private XPView xpView;
    private TileView tileView;
    private World world;

    /**
     * Constructs the main world view object that instantiates the other 4 parts of the world view with the world model
     * that contains all the information about the state of the game and the size of the window.
     * @param screenWidth The width of the window.
     * @param screenHeight The height of the window.
     * @param world The world object see {@link World}.
     * @param mapTileNum The map of the world.
     */
    public WorldView(int screenWidth, int screenHeight, World world, int[][] mapTileNum){
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.world = world;
        this.mapTileNum = mapTileNum;

        this.tileView = new TileView(world.getPlayer(), this.tileSize, this.screenWidth, this.screenHeight, this.mapTileNum);
        this.spriteView = new SpriteView(world.getPlayer(), world.getEnemies(), this.tileSize, this.screenWidth, this.screenHeight);
        this.hpView = new HPView(world.getPlayer(), this.screenWidth, this.screenHeight, this.tileSize);
        this.xpView = new XPView(world.getPlayer(), this.screenWidth);
    }

    /**
     * The main draw method that renders the 4 world views.
     * @param g2
     */
    public void draw(Graphics2D g2){
        tileView.draw(g2);
        spriteView.draw(g2);
        hpView.draw(g2);
        xpView.draw(g2);
    }

    /**
     * Returns the size of each tile.
     * @return The size of a tile.
     */
    public int getTileSize(){
        return this.tileSize;
    }
}
