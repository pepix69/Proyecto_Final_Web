package com.upiiz.Proyecto_final.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface DashboardRepository extends Repository<Object, Long> {

    @Query("SELECT COUNT(*) FROM alumnos")
    Long totalAlumnos();

    @Query("SELECT COUNT(*) FROM carreras")
    Long totalCarreras();

    @Query("""
        SELECT COUNT(*)
        FROM alumnos
        WHERE estatus = true
        """)
    Long alumnosActivos();

}
