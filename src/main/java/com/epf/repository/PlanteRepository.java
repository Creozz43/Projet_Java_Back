package com.epf.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epf.model.Plante;

@Repository
public class PlanteRepository {

    private final JdbcTemplate jdbc;

    public PlanteRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Récupère toutes les plantes.
     */
    public List<Plante> findAll() {
        String sql = """
            SELECT
              id_plante,
              nom,
              point_de_vie,
              attaque_par_seconde,
              degat_attaque,
              cout,
              soleil_par_seconde,
              effet,
              chemin_image
            FROM plante
            """;

        return jdbc.query(sql, (rs, rowNum) -> new Plante(
            rs.getLong("id_plante"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getDouble("soleil_par_seconde"),
            rs.getString("effet"),
            rs.getString("chemin_image")
        ));
    }

    /**
     * Récupère une plante par son ID.
     */
    public Plante findById(Long id) {
        String sql = """
            SELECT
              id_plante,
              nom,
              point_de_vie,
              attaque_par_seconde,
              degat_attaque,
              cout,
              soleil_par_seconde,
              effet,
              chemin_image
            FROM plante
            WHERE id_plante = ?
            """;

        return jdbc.queryForObject(sql,
            (rs, rowNum) -> new Plante(
                rs.getLong("id_plante"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("cout"),
                rs.getDouble("soleil_par_seconde"),
                rs.getString("effet"),
                rs.getString("chemin_image")
            ),
            id
        );
    }

    /**
     * Insère une nouvelle plante dans la base.
     */
    public int create(Plante p) {
        String sql = """
            INSERT INTO plante
              (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;

        return jdbc.update(sql,
            p.getNom(),
            p.getPointDeVie(),
            p.getAttaqueParSeconde(),
            p.getDegatAttaque(),
            p.getCout(),
            p.getSoleilParSeconde(),
            p.getEffet(),
            p.getCheminImage()
        );
    }

    /**
     * Met à jour une plante existante.
     */
    public int update(Plante p) {
        String sql = """
            UPDATE plante SET
              nom               = ?,
              point_de_vie      = ?,
              attaque_par_seconde = ?,
              degat_attaque     = ?,
              cout              = ?,
              soleil_par_seconde  = ?,
              effet             = ?,
              chemin_image      = ?
            WHERE id_plante = ?
            """;

        return jdbc.update(sql,
            p.getNom(),
            p.getPointDeVie(),
            p.getAttaqueParSeconde(),
            p.getDegatAttaque(),
            p.getCout(),
            p.getSoleilParSeconde(),
            p.getEffet(),
            p.getCheminImage(),
            p.getIdPlante()
        );
    }

    /**
     * Supprime une plante par son ID.
     */
    public int delete(Long id) {
        return jdbc.update("DELETE FROM plante WHERE id_plante = ?", id);
    }
}
