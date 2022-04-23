package com.example.zoo.ciudad.model;

import com.example.zoo.estado.model.Estado;
import com.example.zoo.zoologico.model.Zoologico;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @OneToMany(mappedBy = "ciudad")
    @JsonIgnore
    private List<Zoologico> zoologicos;

    public Ciudad() {
    }

    public Ciudad(String descripcion, Estado estado, List<Zoologico> zoologicos) {
        this.descripcion = descripcion;
        this.estado = estado;
        this.zoologicos = zoologicos;
    }

    public Ciudad(long id, String descripcion, Estado estado, List<Zoologico> zoologicos) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.zoologicos = zoologicos;
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

    public List<Zoologico> getZoologicos() {
        return zoologicos;
    }

    public void setZoologicos(List<Zoologico> zoologicos) {
        this.zoologicos = zoologicos;
    }
}
