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
public class CorreoEnviado {

    private Long id;

    private String asunto;

    private String mensaje;

    private String tipo;

    private LocalDateTime fechaEnvio;

    private Long usuarioId;
}