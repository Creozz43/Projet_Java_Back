package com.epf.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.epf.dao.ZombieDao;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;

@Service
public class ZombieServiceImpl implements ZombieService {
    private final ZombieDao dao;

    public ZombieServiceImpl(ZombieDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Zombie> getAll() {
        return dao.findAll();
    }

    @Override
    public Zombie getOne(Long id) {
        return dao.findById(id);
    }

    @Override
    public Zombie create(Zombie zombie) {
        dao.create(zombie);
        return zombie;
    }

    @Override
    public Zombie update(Long id, Zombie zombie) {
        zombie.setId(id);
        dao.update(zombie);
        return zombie;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Zombie> getByMapId(Long mapId) {
        return dao.findByMapId(mapId);
    }
}