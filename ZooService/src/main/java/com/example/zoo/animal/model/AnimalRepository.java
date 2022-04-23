package com.example.zoo.animal.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Optional<Animal> findById (long id);
    Optional<Animal> findByClaveAnimal (String claveAnimal);
    boolean existsByClaveAnimal (String claveAnimal);
    boolean existsById (long id);
}
