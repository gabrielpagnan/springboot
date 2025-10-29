package com.gabrielpagnan.springboot.mapper;

import com.gabrielpagnan.springboot.dto.TecnicoDTO;
import com.gabrielpagnan.springboot.model.Tecnico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {

    TecnicoMapper INSTANCE = Mappers.getMapper(TecnicoMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "senha", source = "senha")
    @Mapping(target = "perfis", source = "perfis")
    Tecnico toEntity(TecnicoDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "senha", source = "senha")
    @Mapping(target = "perfis", source = "perfis")
    TecnicoDTO toDTO(Tecnico entity);
}
