package com.example.zoo.pais.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    Optional<Pais> findById(long id);
    Optional<Pais> findByDescripcion(String descripcion);
    boolean existsById(long id);
    boolean existsByDescripcion(String descripcion);
}
