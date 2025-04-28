package com.epf.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.epf.model.GameMap;

@Repository
public class CarteRepository {
    private final JdbcTemplate jdbc;
    public CarteRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    public List<GameMap> findAll() {
        var sql = """
            SELECT id_map, ligne, colonne, chemin_image
              FROM Map
            """;
        return jdbc.query(sql, (rs, rn) -> new GameMap(
            rs.getLong("id_map"),
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
        ));
    }

    public GameMap findById(Long id) {
        var sql = """
            SELECT id_map, ligne, colonne, chemin_image
              FROM Map
             WHERE id_map = ?
            """;
        return jdbc.queryForObject(sql, (rs, rn) -> new GameMap(
            rs.getLong("id_map"),
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
        ), id);
    }

    public int create(GameMap m) {
        var sql = """
            INSERT INTO Map (ligne, colonne, chemin_image)
            VALUES (?, ?, ?)
            """;
        return jdbc.update(sql, m.getLigne(), m.getColonne(), m.getCheminImage());
    }

    public int update(GameMap m) {
        var sql = """
            UPDATE Map SET
                ligne       = ?,
                colonne     = ?,
                chemin_image= ?
             WHERE id_map = ?
            """;
        return jdbc.update(sql,
            m.getLigne(), m.getColonne(), m.getCheminImage(), m.getIdMap()
        );
    }

    public int delete(Long id) {
        return jdbc.update("DELETE FROM Map WHERE id_map = ?", id);
    }
}
