package com.upiiz.Proyecto_final.controllers.api;

import com.upiiz.Proyecto_final.entities.Alumno;
import com.upiiz.Proyecto_final.services.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoRestController {

    private final AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> listar() {
        return alumnoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Alumno obtener(
            @PathVariable Long id) {

        return alumnoService.obtenerPorId(id);
    }

    @PostMapping
    public Alumno guardar(
            @RequestBody Alumno alumno) {

        return alumnoService.guardar(alumno);
    }

    @PutMapping("/{id}")
    public Alumno actualizar(
            @PathVariable Long id,
            @RequestBody Alumno alumno) {

        return alumnoService.actualizar(id,alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {

        alumnoService.eliminar(id);
    }

}