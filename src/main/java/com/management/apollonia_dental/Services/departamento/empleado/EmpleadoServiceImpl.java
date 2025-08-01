package com.management.apollonia_dental.Services.departamento.empleado;

import com.management.apollonia_dental.dataholders.EmpleadoDh;
import com.management.apollonia_dental.dtos.EmpleadoDto;
import com.management.apollonia_dental.entities.EmpleadoEntity;
import com.management.apollonia_dental.exceptions.BdNotFoundException;
import com.management.apollonia_dental.mapper.EmpleadoMapper;
import com.management.apollonia_dental.repositories.IEmpleadoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements IEmpleadoService {

    private final IEmpleadoRepositoryJpa empleadoRepositoryJpa;
    private final EmpleadoMapper empleadoMapper;

    @Override
    public EmpleadoDto save(EmpleadoDh empleadoDh){
        return empleadoMapper.asDto(
                empleadoRepositoryJpa.save(
                        empleadoMapper.asEntity(empleadoDh)
                )
        );
    };

    @Override
    public EmpleadoDto findById(final Long id){
        final EmpleadoEntity empleadoEntity = empleadoRepositoryJpa.findById(id).orElseThrow(()-> new BdNotFoundException("GET findById - No se encontro empleado con el id: " + id));
        return empleadoMapper.asDto(empleadoEntity);
    }

    @Override
    public List<EmpleadoDto> findAll(){
        final List<EmpleadoEntity> empleadoEntities = empleadoRepositoryJpa.findAll();
        log.warn("GET findAll - No hay departamentos en la Base de Datos");
        return empleadoEntities.stream().map(empleadoMapper::asDto).collect(Collectors.toList());
    }

    @Override
    public EmpleadoDto updateById(final Long id, EmpleadoDh empleadoDh){
        final EmpleadoEntity empleadoEntity = empleadoRepositoryJpa.findById(id).orElseThrow(()-> new RuntimeException("No se encontraron registros."));
        empleadoEntity.setNombre(empleadoDh.nombre());
        empleadoEntity.setApellido(empleadoDh.apellido());
        empleadoEntity.setFechaIngreso(empleadoDh.fechaIngreso());
        empleadoEntity.setCorreo(empleadoDh.correo());
        empleadoEntity.setTelefono(empleadoDh.telefono());
        return empleadoMapper.asDto(empleadoRepositoryJpa.save(empleadoEntity));
    }

    @Override
    public Boolean deleteLogical(final Long id){
        final EmpleadoEntity empleadoEntity = empleadoRepositoryJpa.findById(id).orElseThrow(()-> new BdNotFoundException("GET findById - No se encontro empleado con el id: " + id));
        if(!empleadoEntity.getEstado()) return false;
        empleadoEntity.setEstado(false);
        empleadoRepositoryJpa.save(empleadoEntity);
        return true;
    }

    @Override
    public Boolean deleteById(final Long id){
        final EmpleadoEntity empleadoEntity = empleadoRepositoryJpa.findById(id).orElseThrow(()-> new BdNotFoundException("GET findById - No se encontro empleado con el id: " + id));
        empleadoRepositoryJpa.deleteById(empleadoEntity.getIdEmpleado());
        return true;
    }

}
