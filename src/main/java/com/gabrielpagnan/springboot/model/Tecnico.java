// Tecnico.java
package com.gabrielpagnan.springboot.model;

import com.gabrielpagnan.springboot.model.enums.Perfil;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Tecnico extends Pessoa {

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tecnico_perfis", joinColumns = @JoinColumn(name = "tecnico_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil")
    private Set<Perfil> perfis = new HashSet<>();

    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        perfis.add(Perfil.TECNICO);
    }

    public Set<Perfil> getPerfis() { return perfis; }
    public void setPerfis(Set<Perfil> perfis) { this.perfis = perfis; }
    public List<Chamado> getChamados() { return chamados; }
    public void setChamados(List<Chamado> chamados) { this.chamados = chamados; }
}
