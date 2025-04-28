package com.epf.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.epf.dao.ZombieDao;
import com.epf.model.Zombie;

@Repository
public class ZombieDaoImpl implements ZombieDao {
    private final JdbcTemplate jdbc;

    public ZombieDaoImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Zombie> findAll() {
        return jdbc.query(
            "SELECT * FROM zombie", 
            new BeanPropertyRowMapper<>(Zombie.class)
        );
    }

    @Override
    public Zombie findById(Long id) {
        return jdbc.queryForObject(
            "SELECT * FROM zombie WHERE id = ?", 
            new BeanPropertyRowMapper<>(Zombie.class),
            id
        );
    }

    @Override
    public int create(Zombie z) {
        return jdbc.update(
            "INSERT INTO zombie(name, health, damage, map_id) VALUES (?, ?, ?, ?)",
            z.getName(), z.getHealth(), z.getDamage(), z.getMapId()
        );
    }

    @Override
    public int update(Zombie z) {
        return jdbc.update(
            "UPDATE zombie SET name = ?, health = ?, damage = ?, map_id = ? WHERE id = ?",
            z.getName(), z.getHealth(), z.getDamage(), z.getMapId(), z.getId()
        );
    }

    @Override
    public int delete(Long id) {
        return jdbc.update(
            "DELETE FROM zombie WHERE id = ?", 
            id
        );
    }

    @Override
    public List<Zombie> findByMapId(Long mapId) {
        return jdbc.query(
            "SELECT * FROM zombie WHERE map_id = ?", 
            new BeanPropertyRowMapper<>(Zombie.class),
            mapId
        );
    }
}