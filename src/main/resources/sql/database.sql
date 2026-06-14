-- =====================================================
-- BASE DE DATOS
-- =====================================================

CREATE DATABASE IF NOT EXISTS gestion_escolar
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE gestion_escolar;

-- =====================================================
-- ROLES
-- =====================================================

CREATE TABLE roles(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- =====================================================
-- USUARIOS
-- =====================================================

CREATE TABLE usuarios(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    rol_id BIGINT NOT NULL,

    CONSTRAINT fk_usuario_rol
        FOREIGN KEY (rol_id)
        REFERENCES roles(id)
);

-- =====================================================
-- CARRERAS
-- =====================================================

CREATE TABLE carreras(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    clave VARCHAR(20) NOT NULL UNIQUE,

    nombre VARCHAR(100) NOT NULL,

    descripcion VARCHAR(255),

    estatus BOOLEAN DEFAULT TRUE,

    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    fecha_actualizacion TIMESTAMP NULL
);

-- =====================================================
-- ALUMNOS
-- =====================================================

CREATE TABLE alumnos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    matricula VARCHAR(30) NOT NULL UNIQUE,

    nombre VARCHAR(100) NOT NULL,

    apellido_paterno VARCHAR(100) NOT NULL,

    apellido_materno VARCHAR(100),

    correo VARCHAR(150) NOT NULL UNIQUE,

    telefono VARCHAR(20),

    fecha_nacimiento DATE,

    direccion VARCHAR(255),

    estatus BOOLEAN DEFAULT TRUE,

    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    carrera_id BIGINT NOT NULL,

    CONSTRAINT fk_alumno_carrera
        FOREIGN KEY(carrera_id)
        REFERENCES carreras(id)
);

-- =====================================================
-- HISTORIAL DE CORREOS
-- =====================================================

CREATE TABLE correos_enviados(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    asunto VARCHAR(200) NOT NULL,

    mensaje TEXT NOT NULL,

    tipo ENUM(
        'INDIVIDUAL',
        'MASIVO'
    ) NOT NULL,

    fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    usuario_id BIGINT NOT NULL,

    CONSTRAINT fk_correo_usuario
        FOREIGN KEY(usuario_id)
        REFERENCES usuarios(id)
);

-- =====================================================
-- DESTINATARIOS DE CORREOS
-- =====================================================

CREATE TABLE correo_destinatarios(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    correo_enviado_id BIGINT NOT NULL,

    alumno_id BIGINT NOT NULL,

    enviado BOOLEAN DEFAULT TRUE,

    fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_destinatario_correo
        FOREIGN KEY(correo_enviado_id)
        REFERENCES correos_enviados(id),

    CONSTRAINT fk_destinatario_alumno
        FOREIGN KEY(alumno_id)
        REFERENCES alumnos(id)
);

-- =====================================================
-- INDICES
-- =====================================================

CREATE INDEX idx_alumno_correo
ON alumnos(correo);

CREATE INDEX idx_alumno_matricula
ON alumnos(matricula);

CREATE INDEX idx_usuario_correo
ON usuarios(correo);

CREATE INDEX idx_carrera_nombre
ON carreras(nombre);

-- =====================================================
-- DATOS INICIALES
-- =====================================================

INSERT INTO roles(nombre)
VALUES
('ADMIN');

INSERT INTO usuarios(
    nombre,
    correo,
    password,
    rol_id
)
VALUES(
    'Administrador General',
    'admin@gestion-escolar.com',

    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',

    1
);

-- contraseña:
-- admin123

INSERT INTO carreras(
    clave,
    nombre,
    descripcion
)
VALUES
(
    'ISC',
    'Ingeniería en Sistemas Computacionales',
    'Carrera de Sistemas Computacionales'
),
(
    'IIA',
    'Ingeniería Industrial',
    'Carrera de Ingeniería Industrial'
),
(
    'IGE',
    'Ingeniería en Gestión Empresarial',
    'Carrera de Gestión Empresarial'
);