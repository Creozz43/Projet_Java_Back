package com.epf.dao;
import java.util.List;
import com.epf.model.GameMap;

public interface MapDao {
    List<GameMap> findAll();
    GameMap findById(Long id);
    int create(GameMap map);
    int update(GameMap map);
    int delete(Long id);
}