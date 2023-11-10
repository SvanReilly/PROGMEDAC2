package com.example.pokedex2;

public class Pokemon {
    private String Nombre, Imagen;

    public Pokemon(String nombre, String imagen) {
        this.Nombre = nombre;
        this.Imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}
