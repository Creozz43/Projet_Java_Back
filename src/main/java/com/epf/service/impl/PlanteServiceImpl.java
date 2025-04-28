package com.epf.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.epf.dao.PlanteDao;
import com.epf.model.Plante;
import com.epf.service.PlanteService;

@Service
public class PlanteServiceImpl implements PlanteService {
    private final PlanteDao dao;

    public PlanteServiceImpl(PlanteDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Plante> getAll() {
        return dao.findAll();
    }

    @Override
    public Plante getOne(Long id) {
        return dao.findById(id);
    }

    @Override
    public Plante create(Plante plante) {
        dao.create(plante);
        return plante;
    }

    @Override
    public Plante update(Long id, Plante plante) {
        // on utilise setIdPlante au lieu de setId
        plante.setIdPlante(id);
        dao.update(plante);
        return plante;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
