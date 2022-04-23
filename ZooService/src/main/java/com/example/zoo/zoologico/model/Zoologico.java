package com.example.zoo.zoologico.model;

import com.example.zoo.animal.model.Animal;
import com.example.zoo.ciudad.model.Ciudad;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zoologico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tamanyo;

    @Column(nullable = false)
    private String presupuesto;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @OneToMany(mappedBy = "zoologico")
    @JsonIgnore
    private List<Animal> animales;


    public Zoologico() {
    }

    public Zoologico(String nombre, String tamanyo, String presupuesto, Ciudad ciudad, List<Animal> animales) {
        this.nombre = nombre;
        this.tamanyo = tamanyo;
        this.presupuesto = presupuesto;
        this.ciudad = ciudad;
        this.animales = animales;
    }

    public Zoologico(long id, String nombre, String tamanyo, String presupuesto, Ciudad ciudad, List<Animal> animales) {
        this.id = id;
        this.nombre = nombre;
        this.tamanyo = tamanyo;
        this.presupuesto = presupuesto;
        this.ciudad = ciudad;
        this.animales = animales;
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

    public Ciudad getCiudad_id() {
        return ciudad;
    }

    public void setCiudad_id(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }
}
