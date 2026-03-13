package com.reservacanchasjz.reservacanchasjz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservacanchasjz.reservacanchasjz.model.Cancha;

@RestController
@RequestMapping("/canchas")
public class CanchasController {
    private List<Cancha> canchas = new ArrayList<>();

    @GetMapping
    public List<Cancha> obtenerTodas(){
        return canchas;
    }

    @GetMapping("/{id}")
    public Cancha canchaId(@PathVariable Long id){
        return canchas.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElse(null);

    }

    @PostMapping
    public Cancha crearCancha(@RequestBody Cancha nuevaCancha){
        canchas.add(nuevaCancha);
        return nuevaCancha;
    }
}
