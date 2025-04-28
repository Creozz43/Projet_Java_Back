package com.epf.service;

import java.util.List;
import com.epf.model.Plante;

public interface PlanteService {
    List<Plante> getAll();
    Plante getOne(Long id);
    Plante create(Plante p);
    Plante update(Long id, Plante p);
    void delete(Long id);
}
