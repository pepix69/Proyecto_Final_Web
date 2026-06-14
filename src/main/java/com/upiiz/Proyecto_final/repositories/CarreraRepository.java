package com.upiiz.Proyecto_final.repositories;

import com.upiiz.Proyecto_final.entities.Carrera;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {

    List<Carrera> findAll();

    Optional<Carrera> findById(Long id);

    Optional<Carrera> findByClave(String clave);

    @Query("""
        SELECT *
        FROM carreras
        WHERE nombre LIKE CONCAT('%', :nombre, '%')
        """)
    List<Carrera> buscarPorNombre(String nombre);

    boolean existsByClave(String clave);
}