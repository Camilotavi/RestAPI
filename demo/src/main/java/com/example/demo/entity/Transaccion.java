package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table
@Entity
@Data
public class Transaccion {

    @Id
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "recompensa_id")
    private Recompensa recompensa;

    public Transaccion(int id, Cliente cliente, Recompensa recompensa) {
        this.id = id;
        this.cliente = cliente;
        this.recompensa = recompensa;
    }
}
