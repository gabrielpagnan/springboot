// ChamadoDTO.java
package com.gabrielpagnan.springboot.dto;

import com.gabrielpagnan.springboot.model.enums.Prioridade;
import com.gabrielpagnan.springboot.model.enums.Status;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ChamadoDTO {
    public Integer id;
    
    @NotNull(message = "Data de abertura é obrigatória")
    public LocalDate dataAbertura;
    
    public LocalDate dataFechamento;
    
    @NotNull(message = "Prioridade é obrigatória")
    public Prioridade prioridade;
    
    public Status status;
    
    @NotBlank(message = "Título é obrigatório")
    @Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres")
    public String titulo;
    
    @Size(max = 255, message = "As observações não podem ultrapassar 255 caracteres")
    public String observacoes;
    
    @NotNull(message = "ID do cliente é obrigatório")
    @Positive(message = "ID do cliente deve ser um número positivo")
    public Integer clienteId;
    
    @NotNull(message = "ID do técnico é obrigatório")
    @Positive(message = "ID do técnico deve ser um número positivo")
    public Integer tecnicoId;
}
