package com.upiiz.Proyecto_final.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("usuarios")
public class Usuario {

    @Id
    private Long id;

    private String nombre;

    private String correo;

    private String password;

    private Boolean activo;

    @Column("rol_id")
    private Long rolId;
}