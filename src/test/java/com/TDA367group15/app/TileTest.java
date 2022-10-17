package com.TDA367group15.app;

import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.Tile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class TileTest {

    @Test
    public void testTileID(){
        Tile tile = new Tile(1);

        assertEquals(tile.tileID, 1);
    }

    @Test
    public void testCollideWithHouseTrue(){
        Tile tile = new Tile(5);
        Player player = new Player(12,5);
        tile.collide(player);
        assertTrue(tile.isCollideWithTile());
    }

    @Test
    public void testCollideWithHouseFalse(){
        Tile tile = new Tile(1);
        Player player = new Player(12,5);
        tile.collide(player);
        assertFalse(tile.isCollideWithTile());
    }

    @Test
    public void testCollideWithTreeTrue(){
        Tile tile = new Tile(7);
        Player player = new Player(980,760);
        tile.collide(player);
        assertTrue(tile.isCollideWithTile());
    }

    @Test
    public void testCollideWithTreeFalse(){
        Tile tile = new Tile(3);
        Player player = new Player(980,760);
        tile.collide(player);
        assertFalse(tile.isCollideWithTile());
    }

    @Test
    public void testCollideWithRiverTrue(){
        Tile tile = new Tile(2);
        Player player = new Player(1668,1190);
        tile.collide(player);
        assertTrue(tile.isCollideWithTile());
    }

    @Test
    public void testCollideWithRiverFalse(){
        Tile tile = new Tile(3);
        Player player = new Player(1668,1668);
        tile.collide(player);
        assertFalse(tile.isCollideWithTile());
    }
}
