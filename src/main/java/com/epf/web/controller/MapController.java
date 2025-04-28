package com.epf.web.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epf.model.GameMap;
import com.epf.service.MapService;

@RestController
@RequestMapping("/maps")
public class MapController {
    private final MapService service;
    public MapController(MapService service) { this.service = service; }

    @GetMapping
    public List<GameMap> all() { return service.getAll(); }

    @GetMapping("/validation")
    public ResponseEntity<Void> validateFormat() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameMap> one(@PathVariable Long id) {
        GameMap m = service.getOne(id);
        return m != null ? ResponseEntity.ok(m) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<GameMap> create(@RequestBody GameMap m) {
        service.create(m);
        return ResponseEntity.status(201).body(m);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameMap> update(
            @PathVariable Long id,
            @RequestBody GameMap m) {
        var updated = service.update(id, m);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
