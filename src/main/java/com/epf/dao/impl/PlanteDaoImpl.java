package com.epf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.epf.dao.PlanteDao;
import com.epf.model.Plante;

@Repository
public class PlanteDaoImpl implements PlanteDao {
    private final JdbcTemplate jdbc;
    public PlanteDaoImpl(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private static class R implements RowMapper<Plante> {
        public Plante mapRow(ResultSet rs,int rn)throws SQLException{
            return new Plante(
                rs.getLong("id_plante"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getDouble("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("cout"),
                rs.getDouble("soleil_par_seconde"),
                rs.getString("effet"),
                rs.getString("chemin_image")
            );
        }
    }

    @Override public List<Plante> findAll(){
        return jdbc.query("SELECT * FROM plante", new R());
    }
    @Override public Plante findById(Long id){
        return jdbc.queryForObject("SELECT * FROM plante WHERE id_plante=?", new R(), id);
    }
    @Override public int create(Plante p){
        return jdbc.update("""
            INSERT INTO plante(nom,point_de_vie,attaque_par_seconde,degat_attaque,cout,soleil_par_seconde,effet,chemin_image)
            VALUES(?,?,?,?,?,?,?,?)""",
            p.getNom(),p.getPointDeVie(),p.getAttaqueParSeconde(),
            p.getDegatAttaque(),p.getCout(),p.getSoleilParSeconde(),
            p.getEffet(),p.getCheminImage()
        );
    }
    @Override public int update(Plante p){
        return jdbc.update("""
            UPDATE plante SET nom=?,point_de_vie=?,attaque_par_seconde=?,degat_attaque=?,cout=?,soleil_par_seconde=?,effet=?,chemin_image=?
            WHERE id_plante=?""",
            p.getNom(),p.getPointDeVie(),p.getAttaqueParSeconde(),
            p.getDegatAttaque(),p.getCout(),p.getSoleilParSeconde(),
            p.getEffet(),p.getCheminImage(),p.getId()
        );
    }
    @Override public int delete(Long id){
        return jdbc.update("DELETE FROM plante WHERE id_plante=?", id);
    }
}
