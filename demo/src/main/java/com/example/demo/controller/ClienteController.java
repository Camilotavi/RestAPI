package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/addClient")
    public void agregarCliente(@RequestBody Cliente cliente) {
        repository.save(cliente);
        System.out.println("Exito");
    }
    @GetMapping("/hello")
    public String saludo(){
        return "Hello World";
    }
}
