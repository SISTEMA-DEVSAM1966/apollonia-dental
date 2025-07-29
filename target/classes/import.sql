-- Crear tabla EMPLEADOS
CREATE TABLE IF NOT EXISTS empleados (
    id_empleado BIGINT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_ingreso VARCHAR(10),
    estado BOOLEAN,
    correo VARCHAR(100),
    teléfono VARCHAR(15),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_create BIGINT,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    id_update BIGINT
);
-- Insertar valores de prueba
INSERT INTO empleados (id_empleado, nombre, apellido, fecha_ingreso, estado, correo, teléfono, id_create, id_update)
VALUES (1, 'Carlos', 'Pérez', '2023-01-10', true, 'carlos.perez@empresa.com', '3001234567', 1001, 1001);