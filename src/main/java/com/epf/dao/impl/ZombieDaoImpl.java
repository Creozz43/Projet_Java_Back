package com.epf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.dao.ZombieDao;
import com.epf.model.Zombie;
import com.epf.repository.ZombieRepository;


@Repository
public class ZombieDaoImpl implements ZombieDao {

    private final JdbcTemplate jdbcTemplate;

    public ZombieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class ZombieRowMapper implements RowMapper<Zombie> {
        @Override
        public Zombie mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Zombie(
                rs.getLong("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getDouble("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getObject("id_map", Long.class)
            );
        }
    }

    @Override
    public List<Zombie> findAll() {
        String sql = """
            SELECT id_zombie, nom, point_de_vie,
                   attaque_par_seconde, degat_attaque,
                   vitesse_de_deplacement, chemin_image, id_map
              FROM Zombie
            """;
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    @Override
    public Zombie findById(Long id) {
        String sql = """
            SELECT id_zombie, nom, point_de_vie,
                   attaque_par_seconde, degat_attaque,
                   vitesse_de_deplacement, chemin_image, id_map
              FROM Zombie
             WHERE id_zombie = ?
            """;
        return jdbcTemplate.queryForObject(sql, new ZombieRowMapper(), id);
    }

    @Override
    public int create(Zombie z) {
        String sql = """
            INSERT INTO Zombie
              (nom, point_de_vie, attaque_par_seconde,
               degat_attaque, vitesse_de_deplacement,
               chemin_image, id_map)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;
        return jdbcTemplate.update(sql,
            z.getNom(),
            z.getPointDeVie(),
            z.getAttaqueParSeconde(),
            z.getDegatAttaque(),
            z.getVitesseDeplacement(),
            z.getCheminImage(),
            z.getIdMap()
        );
    }

    @Override
    public int update(Zombie z) {
        String sql = """
            UPDATE Zombie SET
              nom                    = ?,
              point_de_vie           = ?,
              attaque_par_seconde    = ?,
              degat_attaque          = ?,
              vitesse_de_deplacement = ?,
              chemin_image           = ?,
              id_map                 = ?
             WHERE id_zombie = ?
            """;
        return jdbcTemplate.update(sql,
            z.getNom(),
            z.getPointDeVie(),
            z.getAttaqueParSeconde(),
            z.getDegatAttaque(),
            z.getVitesseDeplacement(),
            z.getCheminImage(),
            z.getIdMap(),
            z.getIdZombie()
        );
    }
    @Override
    public int deleteByMapId(Long mapId) {
        return this.jdbcTemplate.update(
            "DELETE FROM Zombie WHERE id_map = ?",
            mapId
        );
    }
    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM Zombie WHERE id_zombie = ?", id);
    }
}
