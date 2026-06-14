package com.upiiz.Proyecto_final.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CorreoDestinatario {

    private Long id;

    private Long correoEnviadoId;

    private Long alumnoId;

    private Boolean enviado;

    private LocalDateTime fechaEnvio;
}