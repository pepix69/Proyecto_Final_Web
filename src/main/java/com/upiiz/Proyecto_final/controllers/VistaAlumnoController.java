package com.upiiz.Proyecto_final.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaAlumnoController {

    @GetMapping("/alumnos")
    public String alumnos(
            HttpSession session
    ) {

        if(session.getAttribute("usuario")==null){
            return "redirect:/";
        }

        return "alumnos";
    }

}