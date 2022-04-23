package com.example.zoo.pais.controller;

import com.example.zoo.continente.model.Continente;

public class PaisDTO {
    private long id;
    private String descripcion;
    private Continente continente;

    public PaisDTO() {
    }

    public PaisDTO(String descripcion, Continente continente) {
        this.descripcion = descripcion;
        this.continente = continente;
    }

    public PaisDTO(long id, String descripcion, Continente continente) {
        this.id = id;
        this.descripcion = descripcion;
        this.continente = continente;
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
}
