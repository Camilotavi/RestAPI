package com.example.demo.integration;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.PeticionModificarPuntos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

public class ClienteControllerTest extends AbstractTest {

    String path = "/cliente";

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void test_ajustarNombre(){
        Cliente cliente = new Cliente();
        cliente.setId(2);
        cliente.setNombre("Pepe");
        ResponseEntity<String> response = restTemplate.postForEntity(path, cliente, String.class);
        Assertions.assertEquals("Cliente guardado", response.getBody());
    }

    @Test
    void test_modificarPuntos() {
        Cliente cliente = new Cliente();
        cliente.setId(2);
        int puntosAumentar = 50;
        restTemplate.put(path + "/puntos", new PeticionModificarPuntos(cliente,puntosAumentar));
        ResponseEntity<Cliente> result = restTemplate.getForEntity(path + "/2", Cliente.class);
        Assertions.assertEquals(55, Objects.requireNonNull(result.getBody()).getPuntos());
    }
    @Test
    void test_agregarCliente() {
        Cliente cliente = new Cliente();
        cliente.setPuntos(10);
        cliente.setNombre("Batman");
        ResponseEntity<Cliente> response = restTemplate.postForEntity(path, cliente, Cliente.class);
        ResponseEntity<Cliente> result = restTemplate.getForEntity(path + "/" + response.getBody().getId(), Cliente.class);
        // Verificar que se ha insertado correctamente el cliente
        Assertions.assertEquals("Batman", Objects.requireNonNull(result.getBody()).getNombre());
    }

    @Test
    void test_obtenerClientes() {
        ResponseEntity<List<Cliente>> response = restTemplate.exchange(
                path + "s",  // Agrega la 's' para pluralizar la ruta
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Cliente>>() {});
        List<Cliente> clientes = response.getBody();
        Assertions.assertNotNull(clientes);
        Assertions.assertFalse(clientes.isEmpty());
    }




    


}
