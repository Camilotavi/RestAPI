package com.example.demo.dto;

import com.example.demo.entity.Cliente;
import lombok.Getter;

@Getter
public class ClienteDTO {

    private String nombre;
    private int puntos;

    public ClienteDTO(Cliente cliente) {
        this.nombre = cliente.getNombre();
        this.puntos = cliente.getPuntos();
    }


}
