package com.epf.web.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;

@RestController
@RequestMapping("/zombies")
public class ZombieController {
    private final ZombieService service;
    public ZombieController(ZombieService service) { this.service = service; }

    @GetMapping
    public List<Zombie> all() { return service.getAll(); }

    @GetMapping("/validation")
    public ResponseEntity<Void> validateFormat() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zombie> one(@PathVariable Long id) {
        Zombie z = service.getOne(id);
        return z != null ? ResponseEntity.ok(z) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Zombie> create(@RequestBody Zombie z) {
        service.create(z);
        return ResponseEntity.status(201).body(z);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zombie> update(
            @PathVariable Long id,
            @RequestBody Zombie z) {
        var updated = service.update(id, z);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
