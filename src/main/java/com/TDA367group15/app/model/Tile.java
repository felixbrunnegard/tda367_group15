package com.TDA367group15.app.model;

public class Tile {

    private boolean collision;
    public String fileName;

    public Tile(int tileID){

        switch (tileID){
            case 1: this.fileName = "earth.png";
                    break;
            case 2: this.fileName = "grass.png";
                break;
            case 3: this.fileName = "sand.png";
                break;
            case 4: this.fileName = "tree.png";
                break;
            case 5: this.fileName = "wall.png";
                break;
            case 6: this.fileName = "water.png";
                break;
            default: this.fileName = null;
                break;
        }
    }

}
