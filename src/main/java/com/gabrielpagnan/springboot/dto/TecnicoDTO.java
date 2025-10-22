// TecnicoDTO.java
package com.gabrielpagnan.springboot.dto;

import com.gabrielpagnan.springboot.model.enums.Perfil;
import jakarta.validation.constraints.*;
import java.util.Set;

public class TecnicoDTO {
    public Integer id;
    
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    public String nome;
    
    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 14, message = "CPF deve ter 11 dígitos")
    public String cpf;
    
    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    public String email;
    
    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    public String senha;
    
    @NotNull(message = "Perfis são obrigatórios")
    @Size(min = 1, message = "Pelo menos um perfil deve ser informado")
    public Set<Perfil> perfis;

    // getters (necessários para serialização JSON)
    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public Set<Perfil> getPerfis() { return perfis; }
}
