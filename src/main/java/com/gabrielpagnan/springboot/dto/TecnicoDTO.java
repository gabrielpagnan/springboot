// TecnicoDTO.java
package com.gabrielpagnan.springboot.dto;

import com.gabrielpagnan.springboot.model.enums.Perfil;
import jakarta.validation.constraints.*;
import java.util.Set;

public class TecnicoDTO {
    public Integer id;
    @NotBlank public String nome;
    @NotBlank public String cpf;
    @Email @NotBlank public String email;
    @NotBlank public String senha;
    public Set<Perfil> perfis;

    // getters (necessários para serialização JSON)
    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public Set<Perfil> getPerfis() { return perfis; }
}
