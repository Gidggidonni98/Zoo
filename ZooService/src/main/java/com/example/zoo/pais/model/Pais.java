package com.example.zoo.pais.model;

import com.example.zoo.continente.model.Continente;
import com.example.zoo.estado.model.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "continente_id")
    private Continente continente;

    @OneToMany(mappedBy = "pais")
    @JsonIgnore
    private List<Estado> estados;

    public Pais() {
    }

    public Pais(String descripcion, Continente continente, List<Estado> estados) {
        this.descripcion = descripcion;
        this.continente = continente;
        this.estados = estados;
    }

    public Pais(long id, String descripcion, Continente continente, List<Estado> estados) {
        this.id = id;
        this.descripcion = descripcion;
        this.continente = continente;
        this.estados = estados;
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

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}
