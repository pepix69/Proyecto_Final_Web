package com.upiiz.Proyecto_final.controllers.api;

import com.upiiz.Proyecto_final.dto.CorreoDTO;
import com.upiiz.Proyecto_final.dto.CorreoMasivoDTO;
import com.upiiz.Proyecto_final.entities.Alumno;
import com.upiiz.Proyecto_final.services.AlumnoService;
import com.upiiz.Proyecto_final.services.CorreoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/correos")
@RequiredArgsConstructor
public class CorreoRestController {

    private final CorreoService correoService;
    private final AlumnoService alumnoService;

    @PostMapping("/individual")
    public String individual(
            @RequestBody CorreoDTO dto) {

        Alumno alumno =
                alumnoService.obtenerPorId(
                        dto.getAlumnoId());

        correoService.enviarCorreoIndividual(
                alumno.getCorreo(),
                dto.getAsunto(),
                dto.getMensaje());

        return "Correo enviado";
    }

    @PostMapping("/masivo")
    public String masivo(
            @RequestBody CorreoMasivoDTO dto) {

        correoService.enviarCorreoMasivo(
                dto.getAsunto(),
                dto.getMensaje());

        return "Correos enviados";
    }

}