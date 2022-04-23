package com.example.zoo.especie.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EspecieRepository extends JpaRepository<Especie, Long> {
    Optional<Especie> findById(long id);
    Optional<Especie> findByNombreComun(String nombreComun);
    boolean existsById(long id);
    boolean existsByNombreComun(String nombreComun);
}
