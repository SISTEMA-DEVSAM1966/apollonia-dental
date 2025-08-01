package com.management.apollonia_dental.mapper;

import com.management.apollonia_dental.dataholders.EmpleadoDh;
import com.management.apollonia_dental.dtos.EmpleadoDto;
import com.management.apollonia_dental.entities.EmpleadoEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    EmpleadoDto asDto(EmpleadoEntity empleadoEntity);

    EmpleadoEntity asEntity(EmpleadoDh empleadoDh);

    List<EmpleadoEntity> asEntityList(List<EmpleadoDh> empleadosDhs);

    List<EmpleadoDto> asDtoList(List<EmpleadoEntity> empleadosEntities);

}
