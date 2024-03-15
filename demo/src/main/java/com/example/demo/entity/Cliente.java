package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Table
@Entity
@Data
public class Cliente {

    @Id
    @Column
    private int id;

    @Column
    private String nombre;

    @Column
    private int puntos;
}
