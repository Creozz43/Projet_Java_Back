package com.epf.test;

import com.epf.dao.impl.ZombieDAOImpl;
import com.epf.model.Zombie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ZombieDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private ZombieDAOImpl zombieDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        zombieDAO = new ZombieDAOImpl(jdbcTemplate);
    }

    @Test
    public void testGetAllZombies() {
        List<Zombie> zombies = List.of(new Zombie());
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(zombies);

        List<Zombie> result = zombieDAO.getAllZombies();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testAddZombie() {
        Zombie zombie = new Zombie();
        doReturn(1).when(jdbcTemplate).update(anyString(), any(Object[].class));

        zombieDAO.addZombie(zombie);

        verify(jdbcTemplate, times(1)).update(anyString(), any(Object[].class));
    }

    @Test
    public void testUpdateZombie() {
        Zombie zombie = new Zombie();
        doReturn(1).when(jdbcTemplate).update(anyString(), any(Object[].class));

        zombieDAO.updateZombie(zombie);

        verify(jdbcTemplate, times(1)).update(anyString(), any(Object[].class));
    }

    @Test
    public void testDeleteZombie() {
        int id = 1;
        doReturn(1).when(jdbcTemplate).update(anyString(), any(Object[].class));

        zombieDAO.deleteZombie(id);

        verify(jdbcTemplate, times(1)).update(anyString(), any(Object[].class));
    }
}