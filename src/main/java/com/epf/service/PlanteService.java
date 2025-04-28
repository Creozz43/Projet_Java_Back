package com.epf.service;

import java.util.List;
import com.epf.model.Plante;

public interface PlanteService {
    List<Plante> getAll();
    Plante getOne(Long id);
    Plante create(Plante plante);
    Plante update(Long id, Plante plante);
    void delete(Long id);
}