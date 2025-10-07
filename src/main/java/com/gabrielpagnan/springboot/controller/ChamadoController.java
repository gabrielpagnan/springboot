// ChamadoController.java
package com.gabrielpagnan.springboot.controller;

import com.gabrielpagnan.springboot.dto.ChamadoDTO;
import com.gabrielpagnan.springboot.model.Chamado;
import com.gabrielpagnan.springboot.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController @RequestMapping("/api/chamados")
public class ChamadoController {
    private final ChamadoService service;
    public ChamadoController(ChamadoService service){ this.service = service; }

    @GetMapping public List<Chamado> list(){ return service.findAll(); }

    @GetMapping("{id}") public Chamado get(@PathVariable Integer id){ return service.findById(id); }

    @PostMapping
    public ResponseEntity<Chamado> create(@Valid @RequestBody ChamadoDTO dto){
        var saved = service.create(dto);
        return ResponseEntity.created(URI.create("/api/chamados/"+saved.getId())).body(saved);
    }

    @PutMapping("{id}") public Chamado update(@PathVariable Integer id, @Valid @RequestBody ChamadoDTO dto){
        return service.update(id, dto);
    }

    @PostMapping("{id}/fechar") public void close(@PathVariable Integer id){ service.close(id); }

    @DeleteMapping("{id}") public void delete(@PathVariable Integer id){ service.delete(id); }
}
