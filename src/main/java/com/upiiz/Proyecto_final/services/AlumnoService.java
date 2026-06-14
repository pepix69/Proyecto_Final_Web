package com.upiiz.Proyecto_final.services;

import com.upiiz.Proyecto_final.entities.Alumno;
import com.upiiz.Proyecto_final.repositories.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public List<Alumno> obtenerTodos() {
        return alumnoRepository.findAll();
    }

    public Alumno obtenerPorId(Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Alumno no encontrado"));
    }

    public Alumno guardar(Alumno alumno) {

        if (alumnoRepository.existsByCorreo(alumno.getCorreo())) {
            throw new RuntimeException("Correo ya registrado");
        }

        if (alumnoRepository.existsByMatricula(alumno.getMatricula())) {
            throw new RuntimeException("Matrícula ya registrada");
        }

        alumno.setFechaRegistro(LocalDateTime.now());
        alumno.setEstatus(true);

        return alumnoRepository.save(alumno);
    }

    public Alumno actualizar(Long id, Alumno alumno) {

        Alumno existente = obtenerPorId(id);

        existente.setNombre(alumno.getNombre());
        existente.setApellidoPaterno(alumno.getApellidoPaterno());
        existente.setApellidoMaterno(alumno.getApellidoMaterno());
        existente.setCorreo(alumno.getCorreo());
        existente.setTelefono(alumno.getTelefono());
        existente.setDireccion(alumno.getDireccion());
        existente.setFechaNacimiento(alumno.getFechaNacimiento());
        existente.setCarreraId(alumno.getCarreraId());

        return alumnoRepository.save(existente);
    }

    public void eliminar(Long id) {
        alumnoRepository.deleteById(id);
    }

    public List<Alumno> buscar(String texto) {
        return alumnoRepository.buscar(texto);
    }

    public List<Alumno> obtenerActivos() {
        return alumnoRepository.obtenerActivos();
    }

}
