package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Recompensa;
import com.example.demo.service.RecompensaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RecompensaController {

    private final RecompensaService service;

    public RecompensaController(RecompensaService service) {
        this.service = service;
    }

    @PostMapping("/recompensa/agregar")
    public void agregarCliente(@RequestBody Recompensa recompensa) {
        service.agregarRecompensa(recompensa);
    }


}
