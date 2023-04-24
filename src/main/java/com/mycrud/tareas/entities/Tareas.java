package com.mycrud.tareas.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Tareas {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;
    public String descripcion;
    @Column(name = "\"fechaCreacion\"")
    public Instant fechaCreacion;
    public Boolean vigente;

    
    public Tareas(int id, String descripcion, Boolean vigente) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = Instant.now();
        this.vigente = vigente;
    }

    protected Tareas() {
    }
}
