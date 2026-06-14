package com.upiiz.Proyecto_final.services;

import com.upiiz.Proyecto_final.entities.Alumno;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CorreoService {

    private final JavaMailSender mailSender;

    private final AlumnoService alumnoService;

    public void enviarCorreoIndividual(
            String correo,
            String asunto,
            String mensaje
    ) {

        SimpleMailMessage mail =
                new SimpleMailMessage();

        mail.setTo(correo);
        mail.setSubject(asunto);
        mail.setText(mensaje);

        mailSender.send(mail);
    }

    public void enviarCorreoMasivo(
            String asunto,
            String mensaje
    ) {

        List<Alumno> alumnos =
                alumnoService.obtenerActivos();

        for (Alumno alumno : alumnos) {

            SimpleMailMessage mail =
                    new SimpleMailMessage();

            mail.setTo(alumno.getCorreo());
            mail.setSubject(asunto);
            mail.setText(mensaje);

            mailSender.send(mail);
        }
    }

}