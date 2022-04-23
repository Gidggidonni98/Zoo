package com.example.zoo.estado.controller;

import com.example.zoo.pais.model.Pais;

public class EstadoDTO {
    private long id;
    private String descripcion;
    private Pais pais;

    public EstadoDTO() {
    }

    public EstadoDTO(String descripcion, Pais pais) {
        this.descripcion = descripcion;
        this.pais = pais;
    }

    public EstadoDTO(long id, String descripcion, Pais pais) {
        this.id = id;
        this.descripcion = descripcion;
        this.pais = pais;
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

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
