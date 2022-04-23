package com.example.zoo.zoologico.controller;

import com.example.zoo.ciudad.model.Ciudad;

public class ZoologicoDTO {
    private long id;
    private String nombre;
    private String tamanyo;
    private String presupuesto;
    private Ciudad ciudad;

    public ZoologicoDTO() {
    }

    public ZoologicoDTO(String nombre, String tamanyo, String presupuesto, Ciudad ciudad) {
        this.nombre = nombre;
        this.tamanyo = tamanyo;
        this.presupuesto = presupuesto;
        this.ciudad = ciudad;
    }

    public ZoologicoDTO(long id, String nombre, String tamanyo, String presupuesto, Ciudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.tamanyo = tamanyo;
        this.presupuesto = presupuesto;
        this.ciudad = ciudad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(String tamanyo) {
        this.tamanyo = tamanyo;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
