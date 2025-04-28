package com.epf.web.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epf.model.GameMap;
import com.epf.service.MapService;

@RestController
@RequestMapping("/api/maps")
public class MapController {
    private final MapService service;

    public MapController(MapService service) {
        this.service = service;
    }

    @GetMapping
    public List<GameMap> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameMap> one(@PathVariable Long id) {
        GameMap m = service.getOne(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<GameMap> create(@RequestBody GameMap m) {
        GameMap created = service.create(m);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameMap> update(@PathVariable Long id, @RequestBody GameMap m) {
        GameMap updated = service.update(id, m);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}