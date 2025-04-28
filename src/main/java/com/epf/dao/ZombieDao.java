package com.epf.dao;

import java.util.List;
import com.epf.model.Zombie;

public interface ZombieDao {
    List<Zombie> findAll();
    Zombie findById(Long id);
    int create(Zombie z);
    int update(Zombie z);
    int delete(Long id);
    int deleteByMapId(Long mapId);
}
