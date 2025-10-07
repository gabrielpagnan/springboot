// Cliente.java
package com.gabrielpagnan.springboot.model;

import com.gabrielpagnan.springboot.model.enums.Perfil;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa {
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

    public Cliente() { addPerfil(Perfil.CLIENTE); }
    // getters/setters
}
