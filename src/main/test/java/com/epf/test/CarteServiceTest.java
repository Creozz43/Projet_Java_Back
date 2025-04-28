package com.epf.test;

import com.epf.model.GameMap;
import com.epf.dao.MapDAO;
import com.epf.service.MapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CarteServiceTest {

    @Mock
    private MapDAO carteDAO;

    @InjectMocks
    private MapService carteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCartes() {
        List<GameMap> cartes = List.of(new GameMap());
        when(carteDAO.getAllCartes()).thenReturn(cartes);

        List<GameMap> result = carteService.getAllCartes();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testAddCarte() {
        GameMap carte = new GameMap();
        doNothing().when(carteDAO).addCarte(carte);

        carteService.addCarte(carte);

        verify(carteDAO, times(1)).addCarte(carte);
    }

    @Test
    public void testUpdateCarte() {
        GameMap carte = new GameMap();
        doNothing().when(carteDAO).updateCarte(carte);

        carteService.updateCarte(carte);

        verify(carteDAO, times(1)).updateCarte(carte);
    }

    @Test
    public void testDeleteCarte() {
        int id = 1;
        doNothing().when(carteDAO).deleteCarte(id);

        carteService.deleteCarte(id);

        verify(carteDAO, times(1)).deleteCarte(id);
    }
}