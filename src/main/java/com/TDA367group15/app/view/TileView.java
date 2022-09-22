package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TileView extends WorldView {
    private List<Tile> tiles = new ArrayList<>();

    public TileView(){

        this.tiles.add(new Tile(1));
        this.tiles.add(new Tile(2));
        this.tiles.add(new Tile(3));
        this.tiles.add(new Tile(4));
        this.tiles.add(new Tile(5));
        this.tiles.add(new Tile(6));
    }

    public BufferedImage getTileImage(Tile tile){
        BufferedImage image;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/"+ tile.fileName));
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

            g2.drawImage(getTileImage(tiles.get(0)), x, y, tileSize, tileSize, null);
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
