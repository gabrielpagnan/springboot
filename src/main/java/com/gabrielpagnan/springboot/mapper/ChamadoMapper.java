package com.gabrielpagnan.springboot.mapper;

import com.gabrielpagnan.springboot.dto.ChamadoDTO;
import com.gabrielpagnan.springboot.model.Chamado;
import com.gabrielpagnan.springboot.model.Cliente;
import com.gabrielpagnan.springboot.model.Tecnico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ChamadoMapper {

    ChamadoMapper INSTANCE = Mappers.getMapper(ChamadoMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "dataAbertura", source = "dataAbertura")
    @Mapping(target = "dataFechamento", source = "dataFechamento")
    @Mapping(target = "prioridade", source = "prioridade")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "titulo", source = "titulo")
    @Mapping(target = "observacoes", source = "observacoes")
    @Mapping(target = "cliente", source = "clienteId", qualifiedByName = "mapCliente")
    @Mapping(target = "tecnico", source = "tecnicoId", qualifiedByName = "mapTecnico")
    Chamado toEntity(ChamadoDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "dataAbertura", source = "dataAbertura")
    @Mapping(target = "dataFechamento", source = "dataFechamento")
    @Mapping(target = "prioridade", source = "prioridade")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "titulo", source = "titulo")
    @Mapping(target = "observacoes", source = "observacoes")
    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "tecnicoId", source = "tecnico.id")
    ChamadoDTO toDTO(Chamado entity);

    @Named("mapCliente")
    default Cliente mapCliente(Integer id) {
        if (id == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return cliente;
    }

    @Named("mapTecnico")
    default Tecnico mapTecnico(Integer id) {
        if (id == null) {
            return null;
        }
        Tecnico tecnico = new Tecnico();
        tecnico.setId(id);
        return tecnico;
    }
}
