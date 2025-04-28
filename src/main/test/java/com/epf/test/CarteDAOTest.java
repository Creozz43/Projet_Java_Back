package com.epf.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.epf.dao.impl.MapDaoImpl;
import com.epf.model.GameMap;

class CarteDaoTest {
    @Mock JdbcTemplate jdbc;
    @InjectMocks MapDaoImpl dao;

    @BeforeEach void init(){ MockitoAnnotations.openMocks(this); }

    @Test void findAll_maps(){
        when(jdbc.query(anyString(), any(RowMapper.class)))
            .thenReturn(List.of(new GameMap(1L,"M",5,5)));
        var all=dao.findAll();
        assertEquals(1, all.size());
    }
}
