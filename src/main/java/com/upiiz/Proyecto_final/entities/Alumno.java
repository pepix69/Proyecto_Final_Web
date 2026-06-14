package com.upiiz.Proyecto_final.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("alumnos")
public class Alumno {

    @Id
    private Long id;

    private String matricula;

    private String nombre;

    @Column("apellidp_paterno")
    private String apellidoPaterno;

    @Column("apellido_materno")
    private String apellidoMaterno;

    private String correo;

    private String telefono;

    @Column("fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private String direccion;

    private Boolean estatus;

    private LocalDateTime fechaRegistro;

    @Column("carrera_id")
    private Long carreraId;
}