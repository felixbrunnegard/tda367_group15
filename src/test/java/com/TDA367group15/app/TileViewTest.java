package com.TDA367group15.app;

import com.TDA367group15.app.model.Tile;
import com.TDA367group15.app.view.TileView;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileViewTest {

    @Test
    public void testWorldRows(){
        TileView tileView = new TileView();

        assertEquals(tileView.getWorld("/map.csv").size(), 203);
    }

    @Test
    public void testWorldColumns(){
        TileView tileView = new TileView();

        assertEquals(tileView.getWorld("/map.csv").get(0).length, 115);
    }

    @Test
    public void testGrassImage(){
        TileView tileView = new TileView();

        assertNotNull(tileView.getTileImage(new Tile(1)));
    }

    @Test
    public void testWaterImage(){
        TileView tileView = new TileView();

        assertNotNull(tileView.getTileImage(new Tile(2)));
    }

    @Test
    public void testFloorImage(){
        TileView tileView = new TileView();

        assertNotNull(tileView.getTileImage(new Tile(3)));
    }

    @Test
    public void testWallImage(){
        TileView tileView = new TileView();

        assertNotNull(tileView.getTileImage(new Tile(4)));
    }

    @Test
    public void testLogImage(){
        TileView tileView = new TileView();

        assertNotNull(tileView.getTileImage(new Tile(5)));
    }

    @Test
    public void testSandImage(){
        TileView tileView = new TileView();

        assertNotNull(tileView.getTileImage(new Tile(6)));
    }

    @Test
    public void testTreeImage(){
        TileView tileView = new TileView();

        assertNotNull(tileView.getTileImage(new Tile(7)));
    }

    @Test
    public void testNoImage(){
        TileView tileView = new TileView();

        assertNull(tileView.getTileImage(new Tile(8)));
    }
}
