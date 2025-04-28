package com.epf.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.epf.dao.MapDao;
import com.epf.model.GameMap;

@Repository
public class MapDaoImpl implements MapDao {
    private final JdbcTemplate jdbc;

    public MapDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<GameMap> findAll() {
        return jdbc.query(
            "SELECT * FROM game_map", 
            new BeanPropertyRowMapper<>(GameMap.class)
        );
    }

    @Override
    public GameMap findById(Long id) {
        return jdbc.queryForObject(
            "SELECT * FROM game_map WHERE id = ?", 
            new BeanPropertyRowMapper<>(GameMap.class),
            id
        );
    }

    @Override
    public int create(GameMap m) {
        return jdbc.update(
            "INSERT INTO game_map(terrain_type) VALUES(?)",
            m.getTerrainType()
        );
    }

    @Override
    public int update(GameMap m) {
        return jdbc.update(
            "UPDATE game_map SET terrain_type = ? WHERE id = ?",
            m.getTerrainType(), m.getId()
        );
    }

    @Override
    public int delete(Long id) {
        return jdbc.update(
            "DELETE FROM game_map WHERE id = ?", 
            id
        );
    }
}