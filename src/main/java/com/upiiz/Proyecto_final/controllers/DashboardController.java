package com.upiiz.Proyecto_final.controllers;

import com.upiiz.Proyecto_final.services.DashboardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/dashboard")
    public String dashboard(
            HttpSession session,
            Model model
    ) {

        if (session.getAttribute("usuario") == null) {
            return "redirect:/";
        }

        model.addAttribute(
                "totalAlumnos",
                dashboardService.totalAlumnos());

        model.addAttribute(
                "totalCarreras",
                dashboardService.totalCarreras());

        return "dashboard";
    }

}