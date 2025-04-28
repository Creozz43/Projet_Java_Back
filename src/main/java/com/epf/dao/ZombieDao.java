package com.epf.dao;
import java.util.List;
import com.epf.model.Zombie;

public interface ZombieDao {
    List<Zombie> findAll();
    Zombie findById(Long id);
    int create(Zombie zombie);
    int update(Zombie zombie);
    int delete(Long id);
    List<Zombie> findByMapId(Long mapId);
}