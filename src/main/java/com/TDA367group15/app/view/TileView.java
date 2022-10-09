package com.TDA367group15.app.view;

import com.TDA367group15.app.model.GameLoop;
import com.TDA367group15.app.model.Map;
import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TileView extends WorldView {
    private List<Tile> tiles = new ArrayList<>();
    public List<BufferedImage> images = new ArrayList<>();
    int mapTileNum[][];
    private Map map = new Map();
    private Player player;

    public TileView(Player player){

        this.tiles.add(new Tile(1));
        this.tiles.add(new Tile(2));
        this.tiles.add(new Tile(3));
        this.tiles.add(new Tile(4));
        this.tiles.add(new Tile(5));
        this.tiles.add(new Tile(6));
        this.tiles.add(new Tile(7));

        loadTileImage();

        mapTileNum = map.loadMap("/map.csv");

        this.player = player;
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

    @Override
    public void draw(Graphics2D g2){

        int col = 0;
        int row = 0;

        while(col < mapTileNum[0].length && row < mapTileNum.length){

            int tileNum = mapTileNum[row][col];

            int x = col * tileSize;
            int y = row * tileSize;
            int screenX = x - player.getPosition().getX() + GameView.SCREEN_WIDTH/2;
            int screenY = y - player.getPosition().getY() + GameView.SCREEN_ROW /2;

            if (x + tileSize > player.getPosition().getX() - GameView.SCREEN_WIDTH/2 &&
                x - tileSize < player.getPosition().getX() + GameView.SCREEN_WIDTH/2 &&
                y + tileSize > player.getPosition().getY() - GameView.SCREEN_ROW/2 &&
                y - tileSize < player.getPosition().getY() + GameView.SCREEN_ROW/2) {
                if (tileNum == 0){
                    System.out.println(row);
                }
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
