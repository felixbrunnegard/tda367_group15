package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Map;
import com.TDA367group15.app.model.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TileView extends WorldView {
    private List<Tile> tiles = new ArrayList<>();
    int mapTileNum[][];
    private Map map = new Map();

    public TileView(){

        this.tiles.add(new Tile(1));
        this.tiles.add(new Tile(2));
        this.tiles.add(new Tile(3));
        this.tiles.add(new Tile(4));
        this.tiles.add(new Tile(5));
        this.tiles.add(new Tile(6));
        this.tiles.add(new Tile(7));

        mapTileNum = map.loadMap("/map.csv");
    }

    public String getTileImageFilePath(Tile tile){
        String fileName;

        switch (tile.tileID) {
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

    public BufferedImage getTileImage(Tile tile){
        BufferedImage image;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/" + getTileImageFilePath(tile)));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < maxScreenColumn && row < maxScreenRow){

            int tileNum = mapTileNum[col][row];

            g2.drawImage(getTileImage(tiles.get(tileNum-1)), x, y, tileSize, tileSize, null);
            col++;
            x += tileSize;

            if(col == maxScreenColumn){
                col = 0;
                x = 0;
                row++;
                y += tileSize;
            }
        }
    }

}
