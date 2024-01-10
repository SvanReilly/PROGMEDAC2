package com.example.mapas;

public class Monumento {
    public String id, nombre, descripcion, fecha, latitud, longitud, ciudad, visitable, precio, moneda, imagen, video;

    public Monumento(){
        this.id = "";
        this.nombre = "";
        this.descripcion = "";
        this.fecha = "";
        this.latitud = "";
        this.longitud = "";
        this.ciudad = "";
        this.visitable = "";
        this.precio = "";
        this.moneda = "";
        this.imagen = "";
        this.video = "";
    }

    public  Monumento(String id, String nombre, String descripcion, String fecha, String latitud, String longitud, String ciudad, String visitable, String precio, String moneda, String imagen,  String video){

            this.id = id;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.fecha = fecha;
            this.latitud = latitud;
            this.longitud = longitud;
            this.ciudad = ciudad;
            this.visitable = visitable;
            this.precio = precio;
            this.moneda = moneda;
            this.imagen = imagen;
            this.video = video;
    }
}
