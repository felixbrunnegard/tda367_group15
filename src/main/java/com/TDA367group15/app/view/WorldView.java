package com.TDA367group15.app.view;

import com.TDA367group15.app.model.World;

import java.awt.Graphics2D;

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

    public void draw(Graphics2D g2){
        tileView.draw(g2);
        spriteView.draw(g2);
        hpView.draw(g2);
        xpView.draw(g2);
    }

    public int getTileSize(){
        return this.tileSize;
    }
}
