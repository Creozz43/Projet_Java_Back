package com.epf.test;

import com.epf.model.GameMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarteTest {

    @Test
    public void testCarteConstructorAndGetters() {
        GameMap carte = new GameMap(1, "path/to/image", 2, 3);

        assertEquals(1, carte.getId_map());
        assertEquals("path/to/image", carte.getCheminImage());
        assertEquals(2, carte.getLigne());
        assertEquals(3, carte.getColonne());
    }

    @Test
    public void testCarteSetters() {
        GameMap carte = new GameMap();
        carte.setId_map(1);
        carte.setCheminImage("path/to/image");
        carte.setLigne(2);
        carte.setColonne(3);

        assertEquals(1, carte.getId_map());
        assertEquals("path/to/image", carte.getCheminImage());
        assertEquals(2, carte.getLigne());
        assertEquals(3, carte.getColonne());
    }
}