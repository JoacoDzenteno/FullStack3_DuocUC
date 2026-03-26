package com.reservacanchasjz2.reservacanchajz2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservacanchasjz2.reservacanchajz2.model.Reservas;

@RestController
@RequestMapping("/reservas")
public class ReservasController {
    private static List <Reservas> reservas = new ArrayList<>();

    @GetMapping
    public List <Reservas> obtenerTodas(){
        return reservas;
    }

    @PostMapping
    public Reservas crearReserva(@RequestBody Reservas nuevaReserva){
        reservas.add(nuevaReserva);
        return nuevaReserva;
    }

    @GetMapping("/cancha/{id}")
    public List <Reservas> obtenerPorCancha(@PathVariable Long id){
        return reservas.stream()
        .filter(r -> r.getCanchaId().equals(id))
        .collect(Collectors.toList());
    }


}
