package com.epf.service;

import java.util.List;
import com.epf.model.Zombie;

public interface ZombieService {
    List<Zombie> getAll();
    Zombie getOne(Long id);
    Zombie create(Zombie zombie);
    Zombie update(Long id, Zombie zombie);
    void delete(Long id);
    List<Zombie> getByMapId(Long mapId);
}