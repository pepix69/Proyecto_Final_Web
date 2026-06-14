package com.upiiz.Proyecto_final.services;

import com.upiiz.Proyecto_final.entities.Carrera;
import com.upiiz.Proyecto_final.repositories.CarreraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarreraService {

    private final CarreraRepository carreraRepository;

    public List<Carrera> obtenerTodas() {
        return carreraRepository.findAll();
    }

    public Carrera obtenerPorId(Long id) {
        return carreraRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Carrera no encontrada"));
    }

    public Carrera guardar(Carrera carrera) {

        if (carreraRepository.existsByClave(carrera.getClave())) {
            throw new RuntimeException("La clave ya existe");
        }

        carrera.setEstatus(true);

        return carreraRepository.save(carrera);
    }

    public Carrera actualizar(Long id, Carrera carrera) {

        Carrera existente = obtenerPorId(id);

        existente.setClave(carrera.getClave());
        existente.setNombre(carrera.getNombre());
        existente.setDescripcion(carrera.getDescripcion());

        return carreraRepository.save(existente);
    }

    public void eliminar(Long id) {
        carreraRepository.deleteById(id);
    }

    public List<Carrera> buscarPorNombre(String nombre) {
        return carreraRepository.buscarPorNombre(nombre);
    }

}