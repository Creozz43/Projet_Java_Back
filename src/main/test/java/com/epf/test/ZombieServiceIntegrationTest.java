package com.epf.test;

import com.epf.model.Zombie;
import com.epf.service.ZombieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ZombieServiceIntegrationTest {

    @Autowired
    private ZombieService zombieService;

    @Test
    public void testGetAllZombies() {
        List<Zombie> zombies = zombieService.getAllZombies();
        assertNotNull(zombies);
    }

    @Test
    public void testAddZombie() {
        Zombie zombie = new Zombie(1, "Zombie1", 100, 1.0, 1.0, 10, "path1", 1);
        zombieService.addZombie(zombie);
        List<Zombie> zombies = zombieService.getAllZombies();
        assertTrue(zombies.contains(zombie));
    }

    @Test
    public void testUpdateZombie() {
        Zombie zombie = new Zombie(1, "Zombie1", 100, 1.0, 1.0, 10, "path1", 1);
        zombieService.addZombie(zombie);
        zombie.setNom("UpdatedZombie");
        zombieService.updateZombie(zombie);
        List<Zombie> zombies = zombieService.getAllZombies();
        assertTrue(zombies.stream().anyMatch(z -> z.getNom().equals("UpdatedZombie")));
    }

    @Test
    public void testDeleteZombie() {
        Zombie zombie = new Zombie(1, "Zombie1", 100, 1.0, 1.0, 10, "path1", 1);
        zombieService.addZombie(zombie);
        zombieService.deleteZombie(zombie.getId_zombie());
        List<Zombie> zombies = zombieService.getAllZombies();
        assertFalse(zombies.contains(zombie));
    }

    @Test
    public void testGetZombiesByMapId() {
        Zombie zombie = new Zombie(1, "Zombie1", 100, 1.0, 1.0, 10, "path1", 1);
        zombieService.addZombie(zombie);
        List<Zombie> zombies = zombieService.getZombiesByMapId(1);
        assertNotNull(zombies);
        assertEquals(1, zombies.size());
    }
}