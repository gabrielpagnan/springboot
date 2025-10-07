package com.gabrielpagnan.springboot.controller;

import com.gabrielpagnan.springboot.dto.TecnicoDTO;
import com.gabrielpagnan.springboot.model.Tecnico;
import com.gabrielpagnan.springboot.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    private final TecnicoService service;

    public TecnicoController(TecnicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tecnico> list() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Tecnico get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Tecnico> create(@Valid @RequestBody TecnicoDTO dto) {
        var saved = service.create(dto);
        return ResponseEntity.created(URI.create("/api/tecnicos/" + saved.getId())).body(saved);
    }

    @PutMapping("{id}")
    public Tecnico update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
