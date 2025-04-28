package com.epf.service;

import java.util.List;
import com.epf.model.GameMap;

public interface MapService {
    List<GameMap> getAll();
    GameMap getOne(Long id);
    GameMap create(GameMap m);
    GameMap update(Long id, GameMap m);
    void delete(Long id);
}
