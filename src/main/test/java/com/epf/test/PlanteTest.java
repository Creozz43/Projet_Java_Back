package com.epf.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlanteTest {
    @Test void gettersAndSetters(){
        Plante p = new Plante();
        p.setId(5L);
        p.setNom("A");
        p.setPointDeVie(10);
        p.setAttaqueParSeconde(2.5);
        p.setDegatAttaque(3);
        p.setCout(50);
        p.setSoleilParSeconde(1.2);
        p.setEffet("Z");
        p.setCheminImage("img.png");

        assertEquals(5L, p.getId());
        assertEquals("A", p.getNom());
        assertEquals(10, p.getPointDeVie());
        assertEquals(2.5, p.getAttaqueParSeconde());
        assertEquals(3, p.getDegatAttaque());
        assertEquals(50, p.getCout());
        assertEquals(1.2, p.getSoleilParSeconde());
        assertEquals("Z", p.getEffet());
        assertEquals("img.png", p.getCheminImage());
    }
}
