package com.example.zoo.estado.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findById(long id);
    Optional<Estado> findByDescripcion(String descripcion);
    boolean existsById(long id);
    boolean existsByDescripcion(String descripcion);
}
