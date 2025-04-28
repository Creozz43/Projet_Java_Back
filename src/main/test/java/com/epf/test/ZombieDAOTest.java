package com.epf.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.epf.dao.impl.ZombieDaoImpl;
import com.epf.model.Zombie;

class ZombieDaoTest {
    @Mock JdbcTemplate jdbc;
    @InjectMocks ZombieDaoImpl dao;

    @BeforeEach void init(){ MockitoAnnotations.openMocks(this); }

    @Test void findAll_list(){
        when(jdbc.query(anyString(), any(RowMapper.class)))
            .thenReturn(List.of(new Zombie(1L,"Z",1,1.0,1,"img")));
        var all=dao.findAll();
        assertEquals(1, all.size());
    }
}
