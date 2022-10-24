package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Map;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.Tile;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * The tile view class which renders the map and specifies the design of each tile.
 */
public class TileView{
    private List<Tile> tiles = new ArrayList<>();
    private List<BufferedImage> images = new ArrayList<>();
    private int mapTileNum[][];
    private Player player;
    private int tileSize;
    private int screenWidth;
    private int screenHeight;

    /**
     * Constructs the tile view by creating the graphics of the tiles and assigning the map to the object.
     * @param player The player in the world.
     * @param tileSize The size of each tile.
     * @param screenWidth The width of the screen.
     * @param screenHeight The height of the screen.
     * @param mapTileNum The map of the world.
     */
    public TileView(Player player, int tileSize, int screenWidth, int screenHeight, int[][] mapTileNum){

        this.tiles.add(new Tile(1));
        this.tiles.add(new Tile(2));
        this.tiles.add(new Tile(3));
        this.tiles.add(new Tile(4));
        this.tiles.add(new Tile(5));
        this.tiles.add(new Tile(6));
        this.tiles.add(new Tile(7));

        loadTileImage();

        this.player = player;
        this.tileSize = tileSize;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.mapTileNum = mapTileNum;
    }

    /**
     * Returns the name of a specified tile's image.
     * @param tile The tile which image should be returned.
     * @return A string of the image name.
     */
    public String getTileImageFilePath(Tile tile){
        String fileName;

        switch (tile.getTileNr()) {
            case 1:
                fileName = "grass.png";
                break;
            case 2:
                fileName = "water.png";
                break;
            case 3:
                fileName = "floor.png";
                break;
            case 4:
                fileName = "wall.png";
                break;
            case 5:
                fileName = "log.png";
                break;
            case 6:
                fileName = "sand.png";
                break;
            case 7:
                fileName = "tree.png";
                break;
            default:
                fileName = null;
                break;
        }

        return fileName;
    }

    /**
     * Adds all tile images to a list.
     */
    public void loadTileImage(){
        BufferedImage image;

        for (int i = 0; i < tiles.size(); i++){
            try {
                image = ImageIO.read(getClass().getResourceAsStream("/" + getTileImageFilePath(tiles.get(i))));
                images.add(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The main draw method that renders the map depending on the players position. Each tile is specified by the
     * value in a matrix. The method only renders the tiles directly around the player.
     * @param g2
     */
    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;

        while(col < mapTileNum[0].length && row < mapTileNum.length){

            int tileNum = mapTileNum[row][col];

            int x = col * tileSize;
            int y = row * tileSize;
            int screenX = x - player.getPosition().getX() + screenWidth/2;
            int screenY = y - player.getPosition().getY() + screenHeight /2;

            if (x + tileSize > player.getPosition().getX() - screenWidth/2 &&
                x - tileSize < player.getPosition().getX() + screenWidth/2 &&
                y + tileSize > player.getPosition().getY() - screenHeight/2 &&
                y - tileSize < player.getPosition().getY() + screenHeight/2) {
                g2.drawImage(images.get(tileNum-1), screenX, screenY, tileSize, tileSize, null);
            }

            col++;

            if(col == mapTileNum[row].length){
                col = 0;
                row++;
            }
        }
    }

}
