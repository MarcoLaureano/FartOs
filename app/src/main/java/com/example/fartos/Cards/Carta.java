package com.example.fartos.Cards;

public class Carta {
    private String nombre;
    private int imagen;
    private int id;

    public Carta(String nombre, int imagen, int id) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public int getId() {
        return id;
    }
}
