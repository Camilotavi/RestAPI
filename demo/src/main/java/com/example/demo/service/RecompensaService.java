package com.example.demo.service;

import com.example.demo.repository.RecompensaRepository;
import org.springframework.stereotype.Service;

@Service
public class RecompensaService {

    private final RecompensaRepository repository;

    public RecompensaService(RecompensaRepository repository) {
        this.repository = repository;
    }


}
