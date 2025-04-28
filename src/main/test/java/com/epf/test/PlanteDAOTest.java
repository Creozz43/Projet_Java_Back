package com.epf.dao;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epf.dao.impl.PlanteDaoImpl;
import com.epf.model.Plante;

class PlanteDaoTest {
    @Mock JdbcTemplate jdbc;
    @InjectMocks PlanteDaoImpl dao;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_nonEmpty() {
        when(jdbc.query(anyString(), any(RowMapper.class)))
            .thenReturn(List.of(new Plante(1L,"P",1,1.0,1,1,1.0,"E","img")));
        var all = dao.findAll();
        assertEquals(1, all.size());
    }

    @Test
    void create_invokesUpdate() {
        Plante p = new Plante(null,"P",0,0,0,0,0,"",""); 
        when(jdbc.update(anyString(), any(), any(), any(), any(), any(), any(), any()))
            .thenReturn(1);
        assertEquals(1, dao.create(p));
        verify(jdbc).update(anyString(), any(), any(), any(), any(), any(), any(), any());
    }
}
