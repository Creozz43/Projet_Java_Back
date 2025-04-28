package com.epf.service;

import java.util.List;
import com.epf.model.Zombie;

public interface ZombieService {
    List<Zombie> getAll();
    Zombie getOne(Long id);
    Zombie create(Zombie z);
    Zombie update(Long id, Zombie z);
    void delete(Long id);
}
