package com.example.demo.integration;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.PeticionModificarPuntos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

public class ClienteControllerTest extends AbstractTest {

    String path = "/cliente";

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void test_ajustarNombre(){
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Pepe");
        ResponseEntity<String> response = restTemplate.postForEntity(path, cliente, String.class);
        Assertions.assertEquals("Cliente guardado", response.getBody());
    }

    @Test
    void test_modificarPuntos() {
        Cliente cliente = new Cliente();
        cliente.setId(1);
        int puntosAumentar = 50;
        restTemplate.put(path + "/puntos", new PeticionModificarPuntos(cliente,puntosAumentar));
        ResponseEntity<Cliente> result = restTemplate.getForEntity(path + "/1", Cliente.class);
        Assertions.assertEquals(55, result.getBody().getPuntos());
    }
    /*@Test
    void test_AgregarCliente() {
        Cliente cliente = new Cliente("Batman",10);
        cliente.setId(2);
        ResponseEntity<String> response = restTemplate.postForEntity(path,cliente,String.class);
        ResponseEntity<Cliente> result = restTemplate.getForEntity(path + "/2", Cliente.class);
        Assertions.assertEquals("Julian", result.getBody().getNombre());
    }*/
    


}
