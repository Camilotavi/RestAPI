package com.example.demo.controller;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Recompensa;
import com.example.demo.service.TransaccionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransaccionController {

    private final TransaccionService service;

    public TransaccionController(TransaccionService service) {
        this.service = service;
    }

    @PostMapping("/transaccion/agregar")
    public void registrarTransaccion(@RequestBody Cliente cliente, @RequestBody Recompensa recompensa) {
        service.registrarTransaccion(1,cliente,recompensa);
    }
}
