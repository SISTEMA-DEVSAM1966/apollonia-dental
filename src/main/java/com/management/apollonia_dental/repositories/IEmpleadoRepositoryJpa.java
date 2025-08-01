package com.management.apollonia_dental.repositories;

import com.management.apollonia_dental.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepositoryJpa extends JpaRepository<EmpleadoEntity, Long> {
}
