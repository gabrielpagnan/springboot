package com.gabrielpagnan.springboot.service;

import com.gabrielpagnan.springboot.dto.TecnicoDTO;
import com.gabrielpagnan.springboot.exception.ResourceNotFoundException;
import com.gabrielpagnan.springboot.model.Tecnico;
import com.gabrielpagnan.springboot.repository.TecnicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TecnicoService {

    private final TecnicoRepository repo;

    public TecnicoService(TecnicoRepository repo) {
        this.repo = repo;
    }

    public List<Tecnico> findAll() {
        return repo.findAll();
    }

    public Tecnico findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Técnico com ID " + id + " não encontrado."));
    }

    @Transactional
    public Tecnico create(TecnicoDTO dto) {
        Tecnico t = new Tecnico();
        copy(dto, t);
        return repo.save(t);
    }

    @Transactional
    public Tecnico update(Integer id, TecnicoDTO dto) {
        Tecnico t = findById(id);
        copy(dto, t);
        return repo.save(t);
    }

    public void delete(Integer id) {
        repo.delete(findById(id));
    }

    private void copy(TecnicoDTO dto, Tecnico t) {
        t.setNome(dto.nome);
        t.setCpf(dto.cpf);
        t.setEmail(dto.email);
        t.setSenha(dto.senha);
        if (dto.perfis != null) {
            t.getPerfis().clear();
            t.getPerfis().addAll(dto.perfis);
        }
    }
}
