package com.example.zoo.ciudad.controller;

import com.example.zoo.estado.model.Estado;

public class CiudadDTO {
    private long id;
    private String descripcion;
    private Estado estado;

    public CiudadDTO() {
    }

    public CiudadDTO(String descripcion, Estado estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public CiudadDTO(long id, String descripcion, Estado estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
