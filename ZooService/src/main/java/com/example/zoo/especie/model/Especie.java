package com.example.zoo.especie.model;

import com.example.zoo.animal.model.Animal;
import com.example.zoo.pais.model.Pais;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombreComun;

    @Column(nullable = false)
    private String nombreCientifico;

    @Column(nullable = false)
    private String familia;

    @Column(nullable = false)
    private String peligroExtincion;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "especie")
    @JsonIgnore
    private List<Animal> animales;

    public Especie() {
    }

    public Especie(String nombreComun, String nombreCientifico, String familia, String peligroExtincion, Pais pais, List<Animal> animales) {
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.familia = familia;
        this.peligroExtincion = peligroExtincion;
        this.pais = pais;
        this.animales = animales;
    }

    public Especie(long id, String nombreComun, String nombreCientifico, String familia, String peligroExtincion, Pais pais, List<Animal> animales) {
        this.id = id;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.familia = familia;
        this.peligroExtincion = peligroExtincion;
        this.pais = pais;
        this.animales = animales;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getPeligroExtincion() {
        return peligroExtincion;
    }

    public void setPeligroExtincion(String peligroExtincion) {
        this.peligroExtincion = peligroExtincion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }
}
