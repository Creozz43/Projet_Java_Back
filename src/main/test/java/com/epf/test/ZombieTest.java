package com.epf.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ZombieTest {
    @Test void gettersAndSetters(){
        Zombie z = new Zombie();
        z.setId(2L);
        z.setNom("Z");
        z.setPointDeVie(20);
        z.setVitesse(3.5);
        z.setDegat(4);
        z.setCheminImage("z.png");

        assertEquals(2L, z.getId());
        assertEquals("Z", z.getNom());
        assertEquals(20, z.getPointDeVie());
        assertEquals(3.5, z.getVitesse());
        assertEquals(4, z.getDegat());
        assertEquals("z.png", z.getCheminImage());
    }
}
