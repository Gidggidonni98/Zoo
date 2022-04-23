package com.example.zoo.ciudad.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    Optional<Ciudad> findById (long id);
    Optional<Ciudad> findByDescripcion (String desc);
    Optional<Ciudad> findByEstado_Id (long id);
    boolean existsById (long id);
    boolean existsByDescripcion (String id);
    boolean existsByEstado_Id (long id);
}
