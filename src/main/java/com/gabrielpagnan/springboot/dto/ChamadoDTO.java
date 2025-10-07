// ChamadoDTO.java
package com.gabrielpagnan.springboot.dto;

import com.gabrielpagnan.springboot.model.enums.Prioridade;
import com.gabrielpagnan.springboot.model.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ChamadoDTO {
    public Integer id;
    public LocalDate dataAbertura;
    public LocalDate dataFechamento;
    public Prioridade prioridade;
    public Status status;
    @NotBlank public String titulo;
    public String observacoes;
    @NotNull public Integer clienteId;
    @NotNull public Integer tecnicoId;
}
