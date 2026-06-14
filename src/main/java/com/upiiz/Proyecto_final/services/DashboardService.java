package com.upiiz.Proyecto_final.services;

import com.upiiz.Proyecto_final.repositories.AlumnoRepository;
import com.upiiz.Proyecto_final.repositories.CarreraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final AlumnoRepository alumnoRepository;
    private final CarreraRepository carreraRepository;

    public Long totalAlumnos() {
        return (long) alumnoRepository.findAll().size();
    }

    public Long totalCarreras() {
        return (long) carreraRepository.findAll().size();
    }

}