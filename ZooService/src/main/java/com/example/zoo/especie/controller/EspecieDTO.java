package com.example.zoo.especie.controller;

import com.example.zoo.pais.model.Pais;

public class EspecieDTO {
    private long id;
    private String familia;
    private String nombreComun;
    private String nombreCientifico;
    private String peligroExtincion;
    private Pais pais;

    public EspecieDTO() {
    }

    public EspecieDTO(String familia, String nombreComun, String nombreCientifico, String peligroExtincion, Pais pais) {
        this.familia = familia;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.peligroExtincion = peligroExtincion;
        this.pais = pais;
    }

    public EspecieDTO(long id, String familia, String nombreComun, String nombreCientifico, String peligroExtincion, Pais pais) {
        this.id = id;
        this.familia = familia;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.peligroExtincion = peligroExtincion;
        this.pais = pais;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
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
}
