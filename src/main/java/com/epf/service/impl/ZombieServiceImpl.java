package com.epf.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.epf.repository.ZombieRepository;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;

@Service
public class ZombieServiceImpl implements ZombieService {
    private final ZombieRepository repo;
    public ZombieServiceImpl(ZombieRepository repo) { this.repo = repo; }

    @Override public List<Zombie> getAll() { return repo.findAll(); }
    @Override public Zombie getOne(Long id) { return repo.findById(id); }
    @Override public Zombie create(Zombie z) { repo.create(z); return z; }
    @Override
    public Zombie update(Long id, Zombie z) {
        z.setIdZombie(id);
        repo.update(z);
        return z;
    }
    @Override public void delete(Long id) { repo.delete(id); }
}
