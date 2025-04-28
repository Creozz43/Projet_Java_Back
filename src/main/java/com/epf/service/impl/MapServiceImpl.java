package com.epf.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.epf.dao.MapDao;
import com.epf.model.GameMap;
import com.epf.service.MapService;

@Service
public class MapServiceImpl implements MapService {
    private final MapDao dao;

    public MapServiceImpl(MapDao dao) {
        this.dao = dao;
    }

    @Override
    public List<GameMap> getAll() {
        return dao.findAll();
    }

    @Override
    public GameMap getOne(Long id) {
        return dao.findById(id);
    }

    @Override
    public GameMap create(GameMap map) {
        dao.create(map);
        return map;
    }

    @Override
    public GameMap update(Long id, GameMap map) {
        map.setId(id);
        dao.update(map);
        return map;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}