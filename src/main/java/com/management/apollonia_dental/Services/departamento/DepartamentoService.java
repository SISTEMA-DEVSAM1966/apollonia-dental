package com.management.apollonia_dental.Services.departamento;

import com.management.apollonia_dental.dataholders.DepartamentoDh;
import com.management.apollonia_dental.dtos.DepartamentoDto;

import java.util.List;

public interface DepartamentoService {

    DepartamentoDto save(DepartamentoDh departamentoDh);

    DepartamentoDto findById(Long id);

    List<DepartamentoDto> findAll();

    DepartamentoDto updateById(Long id, DepartamentoDh departamentoDh);

    Boolean deleteLogical(Long id);

    Boolean deleteById(Long id);

}
