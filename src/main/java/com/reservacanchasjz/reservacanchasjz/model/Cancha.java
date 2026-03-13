package com.reservacanchasjz.reservacanchasjz.model;

public class Cancha {
    private Long id;
    private String nombre;
    private String tipo;
    private Double precioPorHora;

    public Cancha() {
    }

    public Cancha(Long id, String nombre, String tipo, Double precioPorHora) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioPorHora = precioPorHora;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Double getPrecioPorHora() {
        return precioPorHora;
    }
    public void setPrecioPorHora(Double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

}
