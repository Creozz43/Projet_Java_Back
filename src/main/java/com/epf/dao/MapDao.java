package com.epf.dao;

import java.util.List;
import com.epf.model.GameMap;

public interface MapDao {
    List<GameMap> findAll();
    GameMap findById(Long id);
    int create(GameMap m);
    int update(GameMap m);
    int delete(Long id);
}
