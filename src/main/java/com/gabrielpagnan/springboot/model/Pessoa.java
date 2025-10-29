// Pessoa.java
package com.gabrielpagnan.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank private String nome;
    @NotBlank @Column(unique = true) private String cpf;
    @Email @NotBlank @Column(unique = true) private String email;
    @NotBlank private String senha;

    private LocalDate dataCriacao = LocalDate.now();

    // getters/setters
    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
    public void setId(Integer id) {
        this.id = id;
    }
}
