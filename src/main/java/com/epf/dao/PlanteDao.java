package com.epf.dao;

import java.util.List;
import com.epf.model.Plante;

public interface PlanteDao {
    List<Plante> findAll();
    Plante findById(Long id);
    int create(Plante p);
    int update(Plante p);
    int delete(Long id);
}
