package com.management.apollonia_dental.Services.departamento;

import com.management.apollonia_dental.dataholders.DepartamentoDh;
import com.management.apollonia_dental.dtos.DepartamentoDto;
import com.management.apollonia_dental.entities.DepartamentoEntity;
import com.management.apollonia_dental.exceptions.BdNotFoundException;
import com.management.apollonia_dental.mapper.DepartamentoMapper;
import com.management.apollonia_dental.repositories.DepartamentoRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartamentoServiceImpl implements DepartamentoService {

    @NonNull
    private final DepartamentoRepository departamentoRepository;

    @NonNull
    private final DepartamentoMapper departamentoMapper;

    @Override
    public DepartamentoDto save(final DepartamentoDh departamentoDh) {
        DepartamentoEntity convertido = departamentoMapper.asEntity(departamentoDh);
        final DepartamentoEntity departamento = this.departamentoMapper.asEntity(departamentoDh);
        final DepartamentoEntity departamentoSaved = this.departamentoRepository.save(departamento);
        final DepartamentoDto departamentoDto = this. departamentoMapper.asDto(departamentoSaved);
        return departamentoDto;
    }

    @Override
    public DepartamentoDto findById(final Long id) {
        final Optional<DepartamentoEntity> departamento = this.departamentoRepository.findById(id);
        if (departamento.isPresent()) {
            final DepartamentoDto departamentoDto = this.departamentoMapper.asDto(departamento.get());
            return departamentoDto;
        } else {
            throw new BdNotFoundException("GET findById - No hay departamento en la Base de Datos con el id: " + id);
        }
    }

    @Override
    public List<DepartamentoDto> findAll() {
        final List<DepartamentoEntity> departamentos = (List<DepartamentoEntity>) this.departamentoRepository.findAll();
        if (CollectionUtils.isEmpty(departamentos)) {
            log.warn("GET findAll - No hay departamentos en la Base de Datos");
            return Collections.emptyList();
        } else {
            final List<DepartamentoDto> departamentoDtos = this.departamentoMapper.asDtoList(departamentos);
            return departamentoDtos;
        }
    }

    @Override
    public DepartamentoDto updateById(final Long id, final DepartamentoDh departamentoDh) {
        if (departamentoDh.getIdDepartamento() != id) {
            throw new BdNotFoundException("PUT updateById - Parametros incorrectos para el campo IdDepartamento: " + departamentoDh.getIdDepartamento() + " es diferente al id: " + id);
        }

        // Recuperamos el original
        final DepartamentoEntity existente = this.departamentoRepository.findById(id)
                .orElseThrow(() -> new BdNotFoundException("PUT updateById - No hay departamento en la Base de Datos con el id: " + id));

        // Convertimos el Dh a entidad
        final DepartamentoEntity departamento = this.departamentoMapper.asEntity(departamentoDh);

        // Mantenemos la fecha de creación del original
        departamento.setFechaCreacion(existente.getFechaCreacion());

        // Guardamos la actualización
        final DepartamentoEntity departamentoSaved = this.departamentoRepository.save(departamento);
        final DepartamentoDto departamentoDto = this.departamentoMapper.asDto(departamentoSaved);
        return departamentoDto;
    }

    @Override
    public Boolean deleteById(final Long id) {
        final boolean existsDeparatamento = this.departamentoRepository.existsById(id);
        if (existsDeparatamento) {
            this.departamentoRepository.deleteById(id);
            return true;
        }
        throw new BdNotFoundException("DELETE deleteById - No hay el dapartamento en la Base de Datos con el id: " + id);
    }

    @Override
    public Boolean deleteLogical(final Long id) {
        final Optional<DepartamentoEntity> departamentoOpt = this.departamentoRepository.findById(id);
        if (departamentoOpt.isPresent()) {
            DepartamentoEntity departamento = departamentoOpt.get();
            departamento.setEstado(false);
            this.departamentoRepository.save(departamento);
            return true;
        }
        throw new BdNotFoundException("DELETE deleteById - No hay el dapartamento en la Base de Datos con el id: " + id);
    }
}
