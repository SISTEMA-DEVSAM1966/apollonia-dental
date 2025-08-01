package com.management.apollonia_dental.dtos;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record EmpleadoDto (Long idEmpleado, String nombre, String apellido, String fechaIngreso, String correo, String telefono, LocalDateTime fechaCreacion, Long idCreate, LocalDateTime fechaModificacion, Long idUpdate, Boolean estado){};
