package com.clubdeportivo2.servicioreservas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// Definimos el nombre y la URL del microservicio al que queremos llamar
// El name es un identificador interno, la url es el destino real (micro de canchas)
@FeignClient(name = "servicio-canchas", url = "http://localhost:8081/api/canchas")
public interface CanchaClient {

    // IMPORTANTE: Este método debe "copiar" la firma del controlador de Canchas
    // Este método debe coincidir con el GetMapping del controlador de Canchas
    // para que Feign sepa a qué endpoint pegarle.
    @GetMapping("/{id}")
    ResponseEntity<?> buscarPorCancha(@PathVariable("id") Long id);
}