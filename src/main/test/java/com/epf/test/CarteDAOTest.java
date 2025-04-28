package com.epf.test;

import com.epf.dao.impl.MapDAOImpl;
import com.epf.model.GameMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarteDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private MapDAOImpl carteDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        carteDAO = new MapDAOImpl(jdbcTemplate);
    }

    @Test
    public void testGetAllCartes() {
        List<GameMap> cartes = List.of(new GameMap());
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(cartes);

        List<GameMap> result = carteDAO.getAllCartes();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testAddCarte() {
        GameMap carte = new GameMap();
        doReturn(1).when(jdbcTemplate).update(anyString(), any(Object[].class));

        carteDAO.addCarte(carte);

        verify(jdbcTemplate, times(1)).update(anyString(), any(Object[].class));
    }

    @Test
    public void testUpdateCarte() {
        GameMap carte = new GameMap();
        doReturn(1).when(jdbcTemplate).update(anyString(), any(Object[].class));

        carteDAO.updateCarte(carte);

        verify(jdbcTemplate, times(1)).update(anyString(), any(Object[].class));
    }

    @Test
    public void testDeleteCarte() {
        int id = 1;
        doReturn(1).when(jdbcTemplate).update(anyString(), any(Object[].class));

        carteDAO.deleteCarte(id);

        verify(jdbcTemplate, times(1)).update(anyString(), any(Object[].class));
    }
}