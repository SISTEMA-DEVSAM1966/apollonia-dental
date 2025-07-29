package com.management.apollonia_dental.mapper;

import com.management.apollonia_dental.dataholders.DepartamentoDh;
import com.management.apollonia_dental.dtos.DepartamentoDto;
import com.management.apollonia_dental.entities.DepartamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartamentoMapper {

    @Mapping(source = "idDepartamento", target = "idDepartamento")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "descripcion", target = "descripcion")
    @Mapping(source = "idCreate", target = "idCreate")
    @Mapping(source = "idUpdate", target = "idUpdate")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "fechaCreacion", target = "fechaCreacion")
    @Mapping(source = "fechaModificacion", target = "fechaModificacion")
    DepartamentoDto asDto(DepartamentoEntity departamento);

    DepartamentoEntity asEntity(DepartamentoDh departamentoDh);

    List<DepartamentoEntity> asEntityList(List<DepartamentoDh> departamentoDhList);

    List<DepartamentoDto> asDtoList(List<DepartamentoEntity> departamento);

}
