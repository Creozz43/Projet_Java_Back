package com.epf.test;

import com.epf.model.Zombie;
import com.epf.dao.ZombieDAO;
import com.epf.service.ZombieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ZombieServiceTest {

    @Mock
    private ZombieDAO zombieDAO;

    @InjectMocks
    private ZombieService zombieService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllZombies() {
        List<Zombie> zombies = List.of(new Zombie());
        when(zombieDAO.getAllZombies()).thenReturn(zombies);

        List<Zombie> result = zombieService.getAllZombies();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testAddZombie() {
        Zombie zombie = new Zombie();
        doNothing().when(zombieDAO).addZombie(zombie);

        zombieService.addZombie(zombie);

        verify(zombieDAO, times(1)).addZombie(zombie);
    }

    @Test
    public void testUpdateZombie() {
        Zombie zombie = new Zombie();
        doNothing().when(zombieDAO).updateZombie(zombie);

        zombieService.updateZombie(zombie);

        verify(zombieDAO, times(1)).updateZombie(zombie);
    }

    @Test
    public void testDeleteZombie() {
        int id = 1;
        doNothing().when(zombieDAO).deleteZombie(id);

        zombieService.deleteZombie(id);

        verify(zombieDAO, times(1)).deleteZombie(id);
    }
    @Test
    public void testGetAllZombieIds() {
        List<Zombie> zombies = List.of(new Zombie(1, "Zombie1", 100, 1.0, 1.0, 10, "path1", 1), new Zombie(2, "Zombie2", 200, 2.0, 2.0, 20, "path2", 1));
        when(zombieDAO.getAllZombies()).thenReturn(zombies);

        List<Integer> zombieIds = zombieService.getAllZombies().stream()
                .map(Zombie::getId_zombie)
                .collect(Collectors.toList());

        String idsPhrase = "Zombie IDs: " + zombieIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(idsPhrase);

        assertEquals("Zombie IDs: 1, 2", idsPhrase);
    }
    @Test
    public void testGetZombiesByMapId() {
        List<Zombie> zombies = List.of(new Zombie(1, "Zombie1", 100, 1.0, 1.0, 10, "path1", 1));
        when(zombieDAO.getZombiesByMapId(1)).thenReturn(zombies);

        List<Zombie> result = zombieService.getZombiesByMapId(1);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getId_zombie());
    }
}
