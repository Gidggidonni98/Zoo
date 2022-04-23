package com.example.zoo.animal.model;

import com.example.zoo.especie.model.Especie;
import com.example.zoo.genero.model.Genero;
import com.example.zoo.zoologico.model.Zoologico;

import javax.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String claveAnimal;

    @Column(nullable = false)
    private String fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "zoologico_id")
    private Zoologico zoologico;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "especie_id")
    private Especie especie;

    public Animal() {
    }

    public Animal(String claveAnimal, String fechaNacimiento, Zoologico zoologico, Genero genero, Especie especie) {
        this.claveAnimal = claveAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.zoologico = zoologico;
        this.genero = genero;
        this.especie = especie;
    }

    public Animal(long id, String claveAnimal, String fechaNacimiento, Zoologico zoologico, Genero genero, Especie especie) {
        this.id = id;
        this.claveAnimal = claveAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.zoologico = zoologico;
        this.genero = genero;
        this.especie = especie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClaveAnimal() {
        return claveAnimal;
    }

    public void setClaveAnimal(String clave_animal) {
        this.claveAnimal = clave_animal;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Zoologico getZoologico() {
        return zoologico;
    }

    public void setZoologico(Zoologico zoologico) {
        this.zoologico = zoologico;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
