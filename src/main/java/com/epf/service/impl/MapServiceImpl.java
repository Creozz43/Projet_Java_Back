package com.epf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epf.repository.CarteRepository;
import com.epf.dao.MapDao;
import com.epf.dao.ZombieDao;
import com.epf.model.GameMap;
import com.epf.service.MapService;

@Service
public class MapServiceImpl implements MapService {
    private final CarteRepository repo;
    public MapServiceImpl(CarteRepository repo) { this.repo = repo; }
    @Autowired
    private MapDao mapDao;

    @Autowired
    private ZombieDao zombieDao;

    @Override
    public void delete(Long id) {
        // 1) on vire tous les zombies rattachés à cette map
        this.zombieDao.deleteByMapId(id);
        
        this.mapDao.delete(id);
    }

    @Override public List<GameMap> getAll() { return repo.findAll(); }
    @Override public GameMap getOne(Long id) { return repo.findById(id); }
    @Override public GameMap create(GameMap m) { repo.create(m); return m; }
    @Override
    public GameMap update(Long id, GameMap m) {
        m.setIdMap(id);
        repo.update(m);
        return m;
    }
    
}
