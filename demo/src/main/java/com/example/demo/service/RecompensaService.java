package com.example.demo.service;

import com.example.demo.entity.Recompensa;
import com.example.demo.repository.RecompensaRepository;
import org.springframework.stereotype.Service;

@Service
public class RecompensaService {

    private final RecompensaRepository repository;

    public RecompensaService(RecompensaRepository repository) {
        this.repository = repository;
    }

    public void agregarRecompensa (Recompensa recompensa){
        repository.save(recompensa);
    }




}
