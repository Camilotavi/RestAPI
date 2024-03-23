package com.example.demo.integration;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Recompensa;
import com.example.demo.entity.Recompensa;
import com.example.demo.integration.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public class RecompensaControllerTest extends AbstractTest {

    String path = "/recompensa";

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void test_ajustarNombreRecompensa(){
        Recompensa recompensa = new Recompensa();
        recompensa.setId(1);
        recompensa.setNombre("iPhone16");
        ResponseEntity<String> response = restTemplate.postForEntity(path, recompensa, String.class);
        Assertions.assertEquals("Recompensa guardada", response.getBody());
    }

    @Test
    void test_ajustarDescripcionRecompensa(){
        Recompensa recompensa = new Recompensa();
        recompensa.setId(1);
        recompensa.setDescripcion("iPhone15 de 1TB");
        ResponseEntity<String> response = restTemplate.postForEntity(path, recompensa, String.class);
        Assertions.assertEquals("Recompensa guardada", response.getBody());
    }

    @Test
    void test_agregarRecompensa() {
        Recompensa recompensa = new Recompensa("Tecno", "AirPods Pro", "AirPods Pro de última generación", 10);
        ResponseEntity<String> response = restTemplate.postForEntity(path,recompensa,String.class);
        ResponseEntity<Recompensa> result = restTemplate.getForEntity(path + "/2", Recompensa.class);
        Assertions.assertEquals("AirPods Pro", result.getBody().getNombre());
    }

    @Test
    void test_obtenerRecompensas() {
        ResponseEntity<List<Recompensa>> response = restTemplate.exchange(
                path + "s",  // Agrega la 's' para pluralizar la ruta
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Recompensa>>() {});

        List<Recompensa> recompensas = response.getBody();
        Assertions.assertNotNull(recompensas);
        Assertions.assertFalse(recompensas.isEmpty());
    }

    @Test
    void test_obtenerClientes() {
        ResponseEntity<List<Recompensa>> response = restTemplate.exchange(
                path + "s",  // Agrega la 's' para pluralizar la ruta
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Recompensa>>() {});

        List<Recompensa> recompensas = response.getBody();
        Assertions.assertNotNull(recompensas);
        Assertions.assertFalse(recompensas.isEmpty());
    }
}
