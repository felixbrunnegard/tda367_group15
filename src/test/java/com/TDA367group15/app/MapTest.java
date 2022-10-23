package com.TDA367group15.app;

import com.TDA367group15.app.model.Map;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapTest {

    @Test
    public void testWorldRows(){
        Map map = new Map();

        assertEquals(map.loadMap("/map.csv").length, 203);
    }

    @Test
    public void testWorldColumns(){
        Map map = new Map();

        assertEquals(map.loadMap("/map.csv")[0].length, 115);
    }
}
