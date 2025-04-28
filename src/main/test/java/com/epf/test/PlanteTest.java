package com.epf.test;

import com.epf.model.Plante;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlanteTest {

    @Test
    public void testPlanteConstructorAndGetters() {
        Plante plante = new Plante(1, "Tournesol", 100, 1.5, 50, 25, 0.5, "Effet", "path/to/image");

        assertEquals(1, plante.getId_plante());
        assertEquals("Tournesol", plante.getNom());
        assertEquals(100, plante.getPoint_de_vie());
        assertEquals(1.5, plante.getAttaque_par_seconde());
        assertEquals(50, plante.getDegat_attaque());
        assertEquals(25, plante.getCout());
        assertEquals(0.5, plante.getSoleil_par_seconde());
        assertEquals("Effet", plante.getEffet());
        assertEquals("path/to/image", plante.getChemin_image());
    }

    @Test
    public void testPlanteSetters() {
        Plante plante = new Plante();
        plante.setId_plante(1);
        plante.setNom("Tournesol");
        plante.setPoint_de_vie(100);
        plante.setAttaque_par_seconde(1.5);
        plante.setDegat_attaque(50);
        plante.setCout(25);
        plante.setSoleil_par_seconde(0.5);
        plante.setEffet("Effet");
        plante.setChemin_image("path/to/image");

        assertEquals(1, plante.getId_plante());
        assertEquals("Tournesol", plante.getNom());
        assertEquals(100, plante.getPoint_de_vie());
        assertEquals(1.5, plante.getAttaque_par_seconde());
        assertEquals(50, plante.getDegat_attaque());
        assertEquals(25, plante.getCout());
        assertEquals(0.5, plante.getSoleil_par_seconde());
        assertEquals("Effet", plante.getEffet());
        assertEquals("path/to/image", plante.getChemin_image());
    }
}