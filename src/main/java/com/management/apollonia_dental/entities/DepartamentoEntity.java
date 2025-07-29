package com.management.apollonia_dental.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "departamentos")
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Long idDepartamento;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 300)
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = true)
    private Timestamp fechaCreacion;

    @Column(name = "id_create")
    private Long idCreate;

    @Column(name = "fecha_modificacion", nullable = true)
    private Timestamp fechaModificacion;

    @Column(name = "id_update")
    private Long idUpdate;

    private Boolean estado;

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
