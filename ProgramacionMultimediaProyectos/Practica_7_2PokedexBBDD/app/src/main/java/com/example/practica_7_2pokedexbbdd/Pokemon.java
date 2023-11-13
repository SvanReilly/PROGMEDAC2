package com.example.practica_7_2pokedexbbdd;

public class Pokemon {
    private String name, picture;

    public Pokemon(String name, String picture) {
        this.name = name;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String v) {
        picture = picture;
    }
}

