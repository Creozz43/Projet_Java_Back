package com.epf.repository;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.epf.model.Zombie;

@Repository
public class ZombieRepository {
    private final JdbcTemplate jdbc;
    public ZombieRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    public List<Zombie> findAll() {
        var sql = """
            SELECT id_zombie, nom, point_de_vie, attaque_par_seconde,
                   degat_attaque, vitesse_de_deplacement, chemin_image, id_map
              FROM Zombie
            """;
        return jdbc.query(sql, (rs, rn) -> new Zombie(
            rs.getLong("id_zombie"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getDouble("vitesse_de_deplacement"),
            rs.getString("chemin_image"),
            rs.getObject("id_map", Long.class)
        ));
    }

    public Zombie findById(Long id) {
        var sql = """
            SELECT id_zombie, nom, point_de_vie, attaque_par_seconde,
                   degat_attaque, vitesse_de_deplacement, chemin_image, id_map
              FROM Zombie
             WHERE id_zombie = ?
            """;
        return jdbc.queryForObject(sql, (rs, rn) -> new Zombie(
            rs.getLong("id_zombie"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getDouble("vitesse_de_deplacement"),
            rs.getString("chemin_image"),
            rs.getObject("id_map", Long.class)
        ), id);
    }

    public int create(Zombie z) {
        var sql = """
            INSERT INTO Zombie
              (nom, point_de_vie, attaque_par_seconde, degat_attaque,
               vitesse_de_deplacement, chemin_image, id_map)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;
        return jdbc.update(sql,
            z.getNom(), z.getPointDeVie(), z.getAttaqueParSeconde(),
            z.getDegatAttaque(), z.getVitesseDeplacement(),
            z.getCheminImage(), z.getIdMap()
        );
    }

    public int update(Zombie z) {
        var sql = """
            UPDATE Zombie SET
              nom                     = ?,
              point_de_vie            = ?,
              attaque_par_seconde     = ?,
              degat_attaque           = ?,
              vitesse_de_deplacement  = ?,
              chemin_image            = ?,
              id_map                  = ?
             WHERE id_zombie = ?
            """;
        return jdbc.update(sql,
            z.getNom(), z.getPointDeVie(), z.getAttaqueParSeconde(),
            z.getDegatAttaque(), z.getVitesseDeplacement(),
            z.getCheminImage(), z.getIdMap(),
            z.getIdZombie()
        );
    }

    public int delete(Long id) {
        return jdbc.update("DELETE FROM Zombie WHERE id_zombie = ?", id);
    }
}
