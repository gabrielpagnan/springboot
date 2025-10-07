// ClienteDTO.java
package com.gabrielpagnan.springboot.dto;

import com.gabrielpagnan.springboot.model.enums.Perfil;
import jakarta.validation.constraints.*;
import java.util.Set;

public class ClienteDTO {
    public Integer id;
    @NotBlank public String nome;
    @NotBlank public String cpf;
    @Email @NotBlank public String email;
    @NotBlank public String senha;
    public Set<Perfil> perfis;
}
