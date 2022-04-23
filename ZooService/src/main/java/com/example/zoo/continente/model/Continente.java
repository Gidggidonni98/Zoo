package com.example.zoo.continente.model;

import com.example.zoo.pais.model.Pais;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Continente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(mappedBy = "continente")
    @JsonIgnore
    private List<Pais> paises;

    public Continente() {
    }

    public Continente(String descripcion, List<Pais> paises) {
        this.descripcion = descripcion;
        this.paises = paises;
    }

    public Continente(long id, String descripcion, List<Pais> paises) {
        this.id = id;
        this.descripcion = descripcion;
        this.paises = paises;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }
}
