package com.management.apollonia_dental.controllers;

import com.management.apollonia_dental.Services.departamento.empleado.IEmpleadoService;
import com.management.apollonia_dental.dataholders.EmpleadoDh;
import com.management.apollonia_dental.dtos.EmpleadoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDto> create(@Validated @RequestBody EmpleadoDh empleadoDh) {
        return ResponseEntity.ok(empleadoService.save(empleadoDh));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDto> findById(@Validated @PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmpleadoDto>> findAll(){
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpleadoDto> update(@Validated @PathVariable Long id, @Validated @RequestBody EmpleadoDh empleadoDh) {
        return ResponseEntity.ok(empleadoService.updateById(id, empleadoDh));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@Validated @PathVariable Long id) {
        return (empleadoService.deleteById(id) ? ResponseEntity.status(HttpStatus.ACCEPTED).body(true) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(false));
    }

    @DeleteMapping(value = "/logic/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> logic(@Validated @PathVariable Long id) {
        return (empleadoService.deleteLogical(id) ? ResponseEntity.status(HttpStatus.ACCEPTED).body(true) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(false));
    }


}
