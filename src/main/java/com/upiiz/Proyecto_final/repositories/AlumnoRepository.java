package com.upiiz.Proyecto_final.repositories;

import com.upiiz.Proyecto_final.entities.Alumno;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

    List<Alumno> findAll();

    Optional<Alumno> findById(Long id);

    Optional<Alumno> findByCorreo(String correo);

    Optional<Alumno> findByMatricula(String matricula);

    boolean existsByCorreo(String correo);

    boolean existsByMatricula(String matricula);

    @Query("""
        SELECT *
        FROM alumnos
        WHERE carrera_id = :carreraId
        """)
    List<Alumno> buscarPorCarrera(Long carreraId);

    @Query("""
        SELECT *
        FROM alumnos
        WHERE nombre LIKE CONCAT('%', :texto, '%')
        OR apellido_paterno LIKE CONCAT('%', :texto, '%')
        OR apellido_materno LIKE CONCAT('%', :texto, '%')
        """)
    List<Alumno> buscar(String texto);

    @Query("""
        SELECT *
        FROM alumnos
        WHERE estatus = true
        """)
    List<Alumno> obtenerActivos();

}
