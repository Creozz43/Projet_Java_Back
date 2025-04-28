package com.epf.web.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epf.model.Plante;
import com.epf.service.PlanteService;

@RestController
@RequestMapping("/api/plantes")
public class PlanteController {
    private final PlanteService service;

    public PlanteController(PlanteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Plante> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plante> one(@PathVariable Long id) {
        Plante p = service.getOne(id);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Plante> create(@RequestBody Plante p) {
        Plante created = service.create(p);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plante> update(@PathVariable Long id, @RequestBody Plante p) {
        // setIdPlante est appelé dans le service
        Plante updated = service.update(id, p);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
