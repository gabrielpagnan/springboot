// Chamado.java
package com.gabrielpagnan.springboot.model;

import com.gabrielpagnan.springboot.model.enums.Prioridade;
import com.gabrielpagnan.springboot.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Chamado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataFechamento;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade = Prioridade.BAIXA;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ABERTO;

    @NotBlank private String titulo;
    private String observacoes;

    @ManyToOne(optional = false) @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(optional = false) @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    // getters/setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public LocalDate getDataAbertura() { return dataAbertura; }
    public void setDataAbertura(LocalDate dataAbertura) { this.dataAbertura = dataAbertura; }
    public LocalDate getDataFechamento() { return dataFechamento; }
    public void setDataFechamento(LocalDate dataFechamento) { this.dataFechamento = dataFechamento; }
    public Prioridade getPrioridade() { return prioridade; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }
}
