package com.example.zoo.estado.model;

import com.example.zoo.ciudad.model.Ciudad;
import com.example.zoo.pais.model.Pais;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<Ciudad> ciudades;

    public Estado() {
    }

    public Estado(String descripcion, Pais pais, List<Ciudad> ciudades) {
        this.descripcion = descripcion;
        this.pais = pais;
        this.ciudades = ciudades;
    }

    public Estado(long id, String descripcion, Pais pais, List<Ciudad> ciudades) {
        this.id = id;
        this.descripcion = descripcion;
        this.pais = pais;
        this.ciudades = ciudades;
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

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
