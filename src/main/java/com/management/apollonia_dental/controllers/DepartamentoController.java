package com.management.apollonia_dental.controllers;

import com.management.apollonia_dental.Services.departamento.DepartamentoService;
import com.management.apollonia_dental.dataholders.DepartamentoDh;
import com.management.apollonia_dental.dtos.DepartamentoDto;
import com.management.apollonia_dental.entities.DepartamentoEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("departamento")
@RequiredArgsConstructor
public class DepartamentoController {

    @NonNull
    private DepartamentoService departamentoService;

    @PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartamentoDto> create(@Validated @RequestBody final DepartamentoDh departamentoDh) {
        System.out.println("Recibido desde Postman: " + departamentoDh);

        return ResponseEntity.ok(this.departamentoService.save(departamentoDh));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartamentoDto> findById(@Validated @PathVariable final Long id) {
        return ResponseEntity.ok(this.departamentoService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartamentoDto>> findAll() {
        return ResponseEntity.ok(this.departamentoService.findAll());
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartamentoDto> updateById(@Validated @PathVariable final Long id, @Validated @RequestBody final DepartamentoDh departamentoDh) {
        return ResponseEntity.ok(this.departamentoService.updateById(id, departamentoDh));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteById(@Validated @PathVariable final Long id) {
        return ResponseEntity.ok(this.departamentoService.deleteById(id));
    }

    @DeleteMapping(value = "/logic/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteLogical(@Validated @PathVariable final Long id) {
        return ResponseEntity.ok(this.departamentoService.deleteLogical(id));
    }
}
