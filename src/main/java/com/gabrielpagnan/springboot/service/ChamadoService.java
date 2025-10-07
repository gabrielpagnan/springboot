package com.gabrielpagnan.springboot.service;

import com.gabrielpagnan.springboot.dto.ChamadoDTO;
import com.gabrielpagnan.springboot.exception.ResourceNotFoundException;
import com.gabrielpagnan.springboot.model.Chamado;
import com.gabrielpagnan.springboot.model.Cliente;
import com.gabrielpagnan.springboot.model.Tecnico;
import com.gabrielpagnan.springboot.model.enums.Status;
import com.gabrielpagnan.springboot.repository.ChamadoRepository;
import com.gabrielpagnan.springboot.repository.ClienteRepository;
import com.gabrielpagnan.springboot.repository.TecnicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepo;
    private final ClienteRepository clienteRepo;
    private final TecnicoRepository tecnicoRepo;

    public ChamadoService(ChamadoRepository chamadoRepo, ClienteRepository clienteRepo, TecnicoRepository tecnicoRepo) {
        this.chamadoRepo = chamadoRepo;
        this.clienteRepo = clienteRepo;
        this.tecnicoRepo = tecnicoRepo;
    }

    public List<Chamado> findAll() {
        return chamadoRepo.findAll();
    }

    public Chamado findById(Integer id) {
        return chamadoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Chamado com ID " + id + " não encontrado."));
    }

    @Transactional
    public Chamado create(ChamadoDTO dto) {
        Chamado ch = new Chamado();
        copy(dto, ch);
        return chamadoRepo.save(ch);
    }

    @Transactional
    public Chamado update(Integer id, ChamadoDTO dto) {
        Chamado ch = findById(id);
        copy(dto, ch);
        return chamadoRepo.save(ch);
    }

    public void close(Integer id) {
        Chamado ch = findById(id);
        ch.setDataFechamento(LocalDate.now());
        ch.setStatus(Status.ENCERRADO);
        chamadoRepo.save(ch);
    }

    public void delete(Integer id) {
        chamadoRepo.delete(findById(id));
    }

    private void copy(ChamadoDTO dto, Chamado ch) {
        ch.setTitulo(dto.titulo);
        ch.setObservacoes(dto.observacoes);
        ch.setPrioridade(dto.prioridade);
        ch.setStatus(dto.status);
        ch.setDataAbertura(dto.dataAbertura);
        ch.setDataFechamento(dto.dataFechamento);

        Cliente cli = clienteRepo.findById(dto.clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + dto.clienteId + " não encontrado."));
        Tecnico tec = tecnicoRepo.findById(dto.tecnicoId)
                .orElseThrow(() -> new ResourceNotFoundException("Técnico com ID " + dto.tecnicoId + " não encontrado."));

        ch.setCliente(cli);
        ch.setTecnico(tec);
    }
}
