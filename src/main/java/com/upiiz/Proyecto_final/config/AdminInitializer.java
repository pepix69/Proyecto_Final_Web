package com.upiiz.Proyecto_final.config;

import com.upiiz.Proyecto_final.entities.Usuario;
import com.upiiz.Proyecto_final.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final UsuarioService usuarioService;

    @Override
    public void run(String... args) {

        Usuario usuario = new Usuario();

        usuario.setNombre("Administrador 1");
        usuario.setCorreo("administrador@escuela.com");
        usuario.setPassword("admin123");
        usuario.setActivo(true);
        usuario.setRolId(1L);

        try {
            usuarioService.guardar(usuario);
        } catch(Exception e) {
            // ya existe
        }
    }
}