package com.upiiz.Proyecto_final.repositories;

import com.upiiz.Proyecto_final.entities.CorreoEnviado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorreoEnviadoRepository
        extends CrudRepository<CorreoEnviado, Long> {

    List<CorreoEnviado> findAll();

}