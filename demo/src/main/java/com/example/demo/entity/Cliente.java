package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;


@Table
@Entity
@Data
public class Cliente {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    @Column
    private int puntos;

    @OneToMany(mappedBy = "cliente")
    private List<Transaccion> transacciones;


}
