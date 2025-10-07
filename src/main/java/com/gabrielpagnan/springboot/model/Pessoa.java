// Pessoa.java
package com.gabrielpagnan.springboot.model;

import com.gabrielpagnan.springboot.model.enums.Perfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank private String nome;
    @NotBlank @Column(unique = true) private String cpf;
    @Email @NotBlank @Column(unique = true) private String email;
    @NotBlank private String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "pessoa_perfis", joinColumns = @JoinColumn(name = "pessoa_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil")
    private Set<Perfil> perfis = new HashSet<>();

    private LocalDate dataCriacao = LocalDate.now();

    // getters/setters
    // + método utilitário
    public void addPerfil(Perfil p){ this.perfis.add(p); }

    // getters & setters gerados (ou usa Lombok se quiser)
    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public Set<Perfil> getPerfis() { return perfis; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setPerfis(Set<Perfil> perfis) { this.perfis = perfis; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
}
