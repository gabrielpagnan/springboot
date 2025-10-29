package com.gabrielpagnan.springboot.mapper;

import com.gabrielpagnan.springboot.dto.ClienteDTO;
import com.gabrielpagnan.springboot.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @ Mapping(target = "id", source = "id")
    @ Mapping(target = "nome", source = "nome")
    @ Mapping(target = "cpf", source = "cpf")
    @ Mapping(target = "email", source = "email")
    @ Mapping(target = "senha", source = "senha")
    @ Mapping(target = "perfis", source = "perfis")
    Cliente toEntity(ClienteDTO dto);

    @ Mapping(target = "id", source = "id")
    @ Mapping(target = "nome", source = "nome")
    @ Mapping(target = "cpf", source = "cpf")
    @ Mapping(target = "email", source = "email")
    @ Mapping(target = "senha", source = "senha")
    @ Mapping(target = "perfis", source = "perfis")
    ClienteDTO toDTO(Cliente entity);
}
