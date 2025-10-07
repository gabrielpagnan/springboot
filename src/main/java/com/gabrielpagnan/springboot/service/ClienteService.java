package com.gabrielpagnan.springboot.service;

import com.gabrielpagnan.springboot.dto.ClienteDTO;
import com.gabrielpagnan.springboot.exception.ResourceNotFoundException;
import com.gabrielpagnan.springboot.model.Cliente;
import com.gabrielpagnan.springboot.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Cliente findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + id + " não encontrado."));
    }

    @Transactional
    public Cliente create(ClienteDTO dto) {
        Cliente c = new Cliente();
        copy(dto, c);
        return repo.save(c);
    }

    @Transactional
    public Cliente update(Integer id, ClienteDTO dto) {
        Cliente c = findById(id);
        copy(dto, c);
        return repo.save(c);
    }

    public void delete(Integer id) {
        repo.delete(findById(id));
    }

    private void copy(ClienteDTO dto, Cliente c) {
        c.setNome(dto.nome);
        c.setCpf(dto.cpf);
        c.setEmail(dto.email);
        c.setSenha(dto.senha);
        if (dto.perfis != null) {
            c.getPerfis().clear();
            c.getPerfis().addAll(dto.perfis);
        }
    }
}
