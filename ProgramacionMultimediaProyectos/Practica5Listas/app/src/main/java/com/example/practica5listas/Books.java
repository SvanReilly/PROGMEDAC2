package com.example.practica5listas;

public class Books {
    private String title;
    private String front_cover;
    private int IBN_code;
    private Date Fecha_publicacion;

    public Books(String title, String front_cover, int IBN_code, Date Fecha_publicacion){
        this.title=title;
        this.front_cover=front_cover;
        this.IBN_code=IBN_code;
        this.Fecha_publicacion=Fecha_publicacion;
    }


}
