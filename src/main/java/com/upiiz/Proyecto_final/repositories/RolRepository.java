package com.upiiz.Proyecto_final.repositories;


import com.upiiz.Proyecto_final.entities.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {

    Optional<Rol> findByNombre(String nombre);

}
