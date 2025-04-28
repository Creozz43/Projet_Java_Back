package com.epf.test;

import com.epf.model.Zombie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZombieTest {

    @Test
    public void testZombieConstructorAndGetters() {
        Zombie zombie = new Zombie(1, "Zombie de base", 150, 1.2, 1.5, 40, "path/to/image", 1);

        assertEquals(1, zombie.getId_zombie());
        assertEquals("Zombie de base", zombie.getNom());
        assertEquals(150, zombie.getPoint_de_vie());
        assertEquals(1.2, zombie.getVitesse_de_deplacement());
        assertEquals(1.5, zombie.getAttaqueParSeconde());
        assertEquals(40, zombie.getDegatsParAttaque());
        assertEquals("path/to/image", zombie.getCheminImage());
        assertEquals(1, zombie.getMapId());
    }

    @Test
    public void testZombieSetters() {
        Zombie zombie = new Zombie();
        zombie.setId_zombie(1);
        zombie.setNom("Zombie de base");
        zombie.setPoint_de_vie(150);
        zombie.setVitesse_de_deplacement(1.2);
        zombie.setAttaqueParSeconde(1.5);
        zombie.setDegatsParAttaque(40);
        zombie.setCheminImage("path/to/image");

        assertEquals(1, zombie.getId_zombie());
        assertEquals("Zombie de base", zombie.getNom());
        assertEquals(150, zombie.getPoint_de_vie());
        assertEquals(1.2, zombie.getVitesse_de_deplacement());
        assertEquals(1.5, zombie.getAttaqueParSeconde());
        assertEquals(40, zombie.getDegatsParAttaque());
        assertEquals("path/to/image", zombie.getCheminImage());
    }
}