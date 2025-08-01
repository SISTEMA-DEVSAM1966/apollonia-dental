package com.management.apollonia_dental.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.lang.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class EmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long idEmpleado;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;

    @Column(name = "fecha_ingreso", length = 10)
    private String fechaIngreso;

    @Column(name = "correo", length = 100)
    private String correo;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "fecha_creacion", nullable = true)
    private Timestamp fechaCreacion;

    @Column(name = "id_create")
    private Long idCreate;

    @Column(name = "fecha_modificacion", nullable = true)
    private Timestamp fechaModificacion;

    @Column(name = "id_update")
    private Long idUpdate;

    private Boolean estado = true;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = new Timestamp(System.currentTimeMillis());
        this.fechaModificacion = null;
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaModificacion = new Timestamp(System.currentTimeMillis());
    }

}
