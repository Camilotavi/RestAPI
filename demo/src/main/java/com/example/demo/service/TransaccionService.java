package com.example.demo.service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Recompensa;
import com.example.demo.entity.Transaccion;
import com.example.demo.repository.TransaccionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public void registrarTransaccion(int id,Cliente cliente, Recompensa recompensa){
        Transaccion transaccion = new Transaccion(id, cliente, recompensa);
        this.transaccionRepository.save(transaccion);
    }
}
