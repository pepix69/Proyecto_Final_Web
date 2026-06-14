package com.upiiz.Proyecto_final.controllers.api;

import com.upiiz.Proyecto_final.dto.LoginDTO;
import com.upiiz.Proyecto_final.entities.Usuario;
import com.upiiz.Proyecto_final.services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthRestController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(
            @RequestBody LoginDTO dto,
            HttpSession session
    ) {

        Usuario usuario =
                usuarioService.login(
                        dto.getCorreo(),
                        dto.getPassword());

        session.setAttribute(
                "usuario",
                usuario);

        return "OK";
    }

    @GetMapping("/logout")
    public String logout(
            HttpSession session
    ) {

        session.invalidate();

        return "OK";
    }

}