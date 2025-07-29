package com.management.apollonia_dental.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DepartamentoDto {

    private Long idDepartamento;

    private String nombre;

    private String descripcion;

    private Long idCreate;

    private LocalDateTime fechaCreacion;

    private Long idUpdate;

    private LocalDateTime fechaModificacion;

    private Boolean estado;

}
