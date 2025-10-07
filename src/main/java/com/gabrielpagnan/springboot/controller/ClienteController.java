package com.gabrielpagnan.springboot.controller;

import com.gabrielpagnan.springboot.dto.ClienteDTO;
import com.gabrielpagnan.springboot.model.Cliente;
import com.gabrielpagnan.springboot.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cliente> list() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Cliente get(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteDTO dto) {
        var saved = service.create(dto);
        return ResponseEntity.created(URI.create("/api/clientes/" + saved.getId())).body(saved);
    }

    @PutMapping("{id}")
    public Cliente update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
