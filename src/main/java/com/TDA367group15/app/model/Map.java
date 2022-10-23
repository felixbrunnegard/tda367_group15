package com.TDA367group15.app.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * {@code Map} is a class which contains methods to place all values in a CSV
 * file into a matrix.
 */
public class Map {

    /**
     * Constructs a map object which contains methods to place values in a CSV file to a matrix.
     */
    public Map(){

    }

    /**
     * Returns a List of ArrayLists which contains the values of a specified CSV file.
     * @param filePath the filepath to the CSV file.
     * @return A List of integer ArrayLists.
     */
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

    /**
     * Returns a matrix of all the values in a CSV file.
     * @param filePath The filepath to the CSV file.
     * @return A matrix containing all values from a CSV file.
     */
    public int[][] loadMap(String filePath){
        int mapTileNum[][];
        List<int[]> world = getWorld(filePath);
        mapTileNum = new int[world.size()][world.get(0).length];
        int col = 0;
        int row = 0;

        while ( col < world.get(0).length && row < world.size()){
            while (col < world.get(row).length){
                int num = world.get(row)[col];
                mapTileNum[row][col] = num;
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
