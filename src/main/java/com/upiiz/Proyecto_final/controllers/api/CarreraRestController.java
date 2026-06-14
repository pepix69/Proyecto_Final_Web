package com.upiiz.Proyecto_final.controllers.api;

import com.upiiz.Proyecto_final.entities.Carrera;
import com.upiiz.Proyecto_final.services.CarreraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
@RequiredArgsConstructor
public class CarreraRestController {

    private final CarreraService carreraService;

    @GetMapping
    public List<Carrera> listar() {
        return carreraService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Carrera obtener(
            @PathVariable Long id) {

        return carreraService.obtenerPorId(id);
    }

    @PostMapping
    public Carrera guardar(
            @RequestBody Carrera carrera) {

        return carreraService.guardar(carrera);
    }

    @PutMapping("/{id}")
    public Carrera actualizar(
            @PathVariable Long id,
            @RequestBody Carrera carrera) {

        return carreraService.actualizar(id,carrera);
    }

    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable Long id) {

        carreraService.eliminar(id);
    }

}