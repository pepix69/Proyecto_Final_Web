package com.upiiz.Proyecto_final.repositories;

import com.upiiz.Proyecto_final.entities.CorreoDestinatario;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorreoDestinatarioRepository
        extends CrudRepository<CorreoDestinatario, Long> {

    @Query("""
        SELECT *
        FROM correo_destinatarios
        WHERE correo_enviado_id = :correoId
        """)
    List<CorreoDestinatario> buscarPorCorreo(Long correoId);

}
