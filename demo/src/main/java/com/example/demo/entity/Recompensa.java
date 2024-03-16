package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table
@Entity
@Data
public class Recompensa {

    @Id
    @Column
    private int id;

    @Column
    private String categoria;

    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private int puntosRequeridos;

    @OneToMany(mappedBy = "recompensa")
    private List<Transaccion> transacciones;
}
