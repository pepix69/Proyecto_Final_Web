package com.upiiz.Proyecto_final.entities;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;


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
