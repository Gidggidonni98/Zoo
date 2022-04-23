package com.example.zoo.animal.controller;

import com.example.zoo.especie.model.Especie;
import com.example.zoo.genero.model.Genero;
import com.example.zoo.zoologico.model.Zoologico;

public class AnimalDTO {
    private long id;
    private String claveAnimal, fechaNacimiento;
    private Zoologico zoologico;
    private Genero genero;
    private Especie especie;

    public AnimalDTO() {
    }

    public AnimalDTO(String claveAnimal, String fechaNacimiento, Zoologico zoologico, Genero genero, Especie especie) {
        this.claveAnimal = claveAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.zoologico = zoologico;
        this.genero = genero;
        this.especie = especie;
    }

    public AnimalDTO(long id, String claveAnimal, String fechaNacimiento, Zoologico zoologico, Genero genero, Especie especie) {
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
