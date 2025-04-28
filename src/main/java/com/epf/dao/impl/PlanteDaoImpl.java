package com.epf.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.epf.dao.PlanteDao;
import com.epf.model.Plante;

@Repository
public class PlanteDaoImpl implements PlanteDao {
    private final JdbcTemplate jdbc;

    public PlanteDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Plante> findAll() {
        String sql = "SELECT id_plante, nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image FROM plante";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Plante.class));
    }

    @Override
    public Plante findById(Long id) {
        String sql = "SELECT id_plante, nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image FROM plante WHERE id_plante = ?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Plante.class), id);
    }

    @Override
    public int create(Plante p) {
        String sql = "INSERT INTO plante(nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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

    @Override
    public int update(Plante p) {
        String sql = "UPDATE plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        return jdbc.update(sql,
            p.getNom(),
            p.getPointDeVie(),
            p.getAttaqueParSeconde(),
            p.getDegatAttaque(),
            p.getCout(),
            p.getSoleilParSeconde(),
            p.getEffet(),
            p.getCheminImage(),
            p.getIdPlante()    // setIdPlante, pas setId
        );
    }

    @Override
    public int delete(Long id) {
        return jdbc.update("DELETE FROM plante WHERE id_plante = ?", id);
    }
}
