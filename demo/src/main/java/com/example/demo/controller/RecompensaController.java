package com.example.demo.controller;

import com.example.demo.service.RecompensaService;
import org.springframework.web.bind.annotation.GetMapping;

public class RecompensaController {

    private final RecompensaService service;

    public RecompensaController(RecompensaService service) {
        this.service = service;
    }


}
