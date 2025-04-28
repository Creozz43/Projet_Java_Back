package com.epf.test;

import com.epf.model.Plante;
import com.epf.dao.PlanteDAO;
import com.epf.service.PlanteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlanteServiceTest {

    @Mock
    private PlanteDAO planteDAO;

    @InjectMocks
    private PlanteService planteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPlantes() {
        List<Plante> plantes = List.of(new Plante());
        when(planteDAO.getAllPlantes()).thenReturn(plantes);

        List<Plante> result = planteService.getAllPlantes();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testAddPlante() {
        Plante plante = new Plante();
        doNothing().when(planteDAO).addPlante(plante);

        planteService.addPlante(plante);

        verify(planteDAO, times(1)).addPlante(plante);
    }

    @Test
    public void testUpdatePlante() {
        Plante plante = new Plante();
        doNothing().when(planteDAO).updatePlante(plante);

        planteService.updatePlante(plante);

        verify(planteDAO, times(1)).updatePlante(plante);
    }

    @Test
    public void testDeletePlante() {
        int id = 1;
        doNothing().when(planteDAO).deletePlante(id);

        planteService.deletePlante(id);

        verify(planteDAO, times(1)).deletePlante(id);
    }
}