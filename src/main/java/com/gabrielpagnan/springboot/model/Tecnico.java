// Tecnico.java
package com.gabrielpagnan.springboot.model;

import com.gabrielpagnan.springboot.model.enums.Perfil;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa {
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() { addPerfil(Perfil.TECNICO); }
    // getters/setters
}
