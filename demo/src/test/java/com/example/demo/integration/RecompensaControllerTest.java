package com.example.demo.integration;

import com.example.demo.entity.Recompensa;
import com.example.demo.integration.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

public class RecompensaControllerTest extends AbstractTest {

    String path = "/recompensa";

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void test_ajustarNombreRecompensa(){
        Recompensa recompensa = new Recompensa();
        recompensa.setId(3);
        recompensa.setNombre("iPhone16");
        ResponseEntity<String> response = restTemplate.postForEntity(path, recompensa, String.class);
        Assertions.assertEquals("Recompensa guardada", response.getBody());
    }

    @Test
    void test_ajustarDescripcionRecompensa(){
        Recompensa recompensa = new Recompensa();
        recompensa.setId(3);
        recompensa.setDescripcion("iPhone15 de 1TB");
        ResponseEntity<String> response = restTemplate.postForEntity(path, recompensa, String.class);
        Assertions.assertEquals("Recompensa guardada", response.getBody());
    }
}
