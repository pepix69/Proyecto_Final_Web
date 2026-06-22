package com.upiiz.Proyecto_final.services;

import com.upiiz.Proyecto_final.entities.Usuario;
import com.upiiz.Proyecto_final.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder encoder;

    public Usuario login(String correo,
                         String password) {

        Usuario usuario = usuarioRepository
                .findByCorreo(correo)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado"));

        System.out.println("Correo recibido: " + correo);
        System.out.println("Password recibido: " + password);
        System.out.println("Password BD: " + usuario.getPassword());


        System.out.println("Password BD: " + usuario.getPassword());
        System.out.println("Password ingresada: " + password);

        boolean valido = password.equals(usuario.getPassword());
        //boolean valido =
        //        encoder.matches(password, usuario.getPassword());

        System.out.println("Resultado: " + valido);

        if (!valido) {
            throw new RuntimeException("Contraseña incorrecta");
        }



        return usuario;
    }

    public Usuario guardar(Usuario usuario) {

        usuario.setPassword(
                encoder.encode(usuario.getPassword())
        );

        return usuarioRepository.save(usuario);
    }

}