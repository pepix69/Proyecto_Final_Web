package com.upiiz.Proyecto_final.entities;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("carreras")
public class Carrera {

    @Id
    private Long id;

    private String clave;

    private String nombre;

    private String descripcion;

    private Boolean estatus;
}
