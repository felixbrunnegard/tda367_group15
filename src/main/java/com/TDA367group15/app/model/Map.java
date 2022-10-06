package com.TDA367group15.app.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Map {

    public Map(){

    }


    public List<int[]> getWorld(String filePath){
        String line;
        int col;
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
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return world;

    }

    public int[][] loadMap(String filePath){
        int mapTileNum[][];
        List<int[]> world = getWorld(filePath);
        mapTileNum = new int[world.get(0).length][world.size()];
        int col = 0;
        int row = 0;

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
        return mapTileNum;
    }

}
