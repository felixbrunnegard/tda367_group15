package com.TDA367group15.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.TDA367group15.app.model.Tile;
import org.junit.Test;

public class TileTest {

    @Test
    public void testTileID(){
        Tile tile = new Tile(1);

        assertEquals(tile.tileID, 1);
    }
}
