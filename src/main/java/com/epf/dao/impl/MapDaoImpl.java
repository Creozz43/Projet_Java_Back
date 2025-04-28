package com.epf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.dao.MapDao;
import com.epf.model.GameMap;

@Repository
public class MapDaoImpl implements MapDao {

    private final JdbcTemplate jdbcTemplate;

    public MapDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class MapRowMapper implements RowMapper<GameMap> {
        @Override
        public GameMap mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new GameMap(
                rs.getLong("id_map"),
                rs.getInt("ligne"),
                rs.getInt("colonne"),
                rs.getString("chemin_image")
            );
        }
    }

    @Override
    public List<GameMap> findAll() {
        String sql = "SELECT id_map, ligne, colonne, chemin_image FROM Map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    @Override
    public GameMap findById(Long id) {
        String sql = "SELECT id_map, ligne, colonne, chemin_image FROM Map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, new MapRowMapper(), id);
    }

    @Override
    public int create(GameMap m) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, m.getLigne(), m.getColonne(), m.getCheminImage());
    }

    @Override
    public int update(GameMap m) {
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        return jdbcTemplate.update(sql, m.getLigne(), m.getColonne(), m.getCheminImage(), m.getIdMap());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM Map WHERE id_map = ?", id);
    }
}
