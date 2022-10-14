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
    public void testCollideWithTileTrue(){
        Tile tile = new Tile(5);
        Player player = new Player(12,5);
        tile.collide(player);
        assertTrue(tile.isCollideWithTile());
    }

    @Test
    public void testCollideWithTileFalse(){
        Tile tile = new Tile(5);
        Player player = new Player(12,15);
        tile.collide(player);
        assertFalse(tile.isCollideWithTile());
    }
}
