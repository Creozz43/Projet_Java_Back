package com.epf.test;

import com.epf.dao.impl.PlanteDAOImpl;
import com.epf.model.Plante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlanteDAOTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private PlanteDAOImpl planteDAO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        planteDAO = new PlanteDAOImpl(jdbcTemplate);
    }

    @Test
    public void testGetAllPlantes() {
        List<Plante> plantes = List.of(new Plante());
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(plantes);

        List<Plante> result = planteDAO.getAllPlantes();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testAddPlante() {
        Plante plante = new Plante();
        doReturn(1).when(jdbcTemplate).update(anyString(), any(Object[].class));

        planteDAO.addPlante(plante);

        verify(jdbcTemplate, times(1)).update(anyString(), any(Object[].class));
    }

    @Test
    public void testUpdatePlante() {
        Plante plante = new Plante();
        doReturn(1).when(jdbcTemplate).update(anyString(), any(Object[].class));

        planteDAO.updatePlante(plante);

        verify(jdbcTemplate, times(1)).update(anyString(), any(Object[].class));
    }

    @Test
    public void testDeletePlante() {
        int id = 1;
        doReturn(1).when(jdbcTemplate).update(anyString(), any(Object[].class));

        planteDAO.deletePlante(id);

        verify(jdbcTemplate, times(1)).update(anyString(), any(Object[].class));
    }
}