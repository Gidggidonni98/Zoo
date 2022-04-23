package com.example.zoo.zoologico.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ZoologicoRepository extends JpaRepository<Zoologico, Long> {
    Optional<Zoologico> findById (long id);
    Optional<Zoologico> findByNombre (String nombre);
    boolean existsByNombre (String nombre);
    boolean existsById (long id);
}
