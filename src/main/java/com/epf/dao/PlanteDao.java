package com.epf.dao;

import java.util.List;
import com.epf.model.Plante;

public interface PlanteDao {
    List<Plante> findAll();
    Plante findById(Long id);
    int create(Plante plante);
    int update(Plante plante);
    int delete(Long id);
}