package com.epf.web.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epf.model.Plante;
import com.epf.service.PlanteService;

@RestController

@RequestMapping("/plantes")
public class PlanteController {
    private final PlanteService service;
    public PlanteController(PlanteService s){ this.service=s; }

    @GetMapping
    public List<Plante> all(){ return service.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Plante> one(@PathVariable Long id){
        Plante p = service.getOne(id);
        return p!=null?ResponseEntity.ok(p):ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Plante> create(@RequestBody Plante p){
        return ResponseEntity.status(201).body(service.create(p));
    }

    @PutMapping("/{id}")
    public Plante update(@PathVariable Long id,@RequestBody Plante p){
        return service.update(id,p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<Void> validateFormat() {
        return ResponseEntity.ok().build();
    }
}
