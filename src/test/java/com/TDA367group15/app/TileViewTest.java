package com.TDA367group15.app;

import com.TDA367group15.app.model.Player;
import com.TDA367group15.app.model.Tile;
import com.TDA367group15.app.view.TileView;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileViewTest {

    @Test
    public void testTotalImages(){
        TileView tileView = new TileView(new Player());

        assertEquals(7, tileView.images.size());
    }

}
