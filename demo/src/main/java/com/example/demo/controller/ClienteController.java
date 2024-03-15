package com.example.demo.controller;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;

import java.util.List;

@RestController
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/cliente/agregar")
    public void agregarCliente(@RequestBody Cliente cliente) {
        service.anadirCliente(cliente);
    }
    @GetMapping("/cliente/obtenerTodos")
    public List<ClienteDTO> obtenerTodosClientes(){
        return service.obtenerClientes();
    }

    @PutMapping("/cliente/aumentarPuntos/{id}")
    public void aumentarPuntosClienteEspecifico(@PathVariable int id){
        return service.sumarPuntos(id,);
    }
}
