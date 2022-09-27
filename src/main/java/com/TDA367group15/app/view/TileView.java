package com.TDA367group15.app.view;

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

    public TileView(){

        this.tiles.add(new Tile(1));
        this.tiles.add(new Tile(2));
        this.tiles.add(new Tile(3));
        this.tiles.add(new Tile(4));
        this.tiles.add(new Tile(5));
        this.tiles.add(new Tile(6));
        this.tiles.add(new Tile(7));

        loadMap("/map.csv");
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

    public void loadMap(String filePath){
        String line;
        int row = 0;
        int col = 0;
        List<int[]> world = new ArrayList<>();

        InputStream is = getClass().getResourceAsStream(filePath);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))){
            while ( (line = br.readLine()) != null){
                String[] numbers = line.split(",");
                int numberArray[] = new int[numbers.length];
                for (col = 0; col < numbers.length; col++){
                    int num = Integer.parseInt(numbers[col]);
                    numberArray[col] = num;
                }
                world.add(numberArray);
                row += 1;
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        mapTileNum = new int[world.get(0).length][world.size()];
        col = 0;
        row = 0;

        while ( col < world.get(row).length && row < world.size()-1){
            while (col < world.get(0).length){
                int num = world.get(row)[col];
                mapTileNum[col][row] = num;
                col += 1;
            }
            if (col == world.get(row).length){
                col = 0;
                row += 1;
            }
        }

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
