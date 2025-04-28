package com.epf.service;

import java.util.List;
import com.epf.model.GameMap;

public interface MapService {
    List<GameMap> getAll();
    GameMap getOne(Long id);
    GameMap create(GameMap map);
    GameMap update(Long id, GameMap map);
    void delete(Long id);
}