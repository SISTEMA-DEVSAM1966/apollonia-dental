package com.management.apollonia_dental.Services.departamento.empleado;

import com.management.apollonia_dental.dataholders.EmpleadoDh;
import com.management.apollonia_dental.dtos.EmpleadoDto;

import java.util.List;

public interface IEmpleadoService {
    EmpleadoDto save(EmpleadoDh empleadoDh);

    EmpleadoDto findById(final Long id);

    List<EmpleadoDto> findAll();

    EmpleadoDto updateById(final Long id, EmpleadoDh empleadoDh);

    Boolean deleteLogical(final Long id);

    Boolean deleteById(final Long id);
}
