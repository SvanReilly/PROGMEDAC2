package com.example.tema7_act_01;
//Paulo Romeo Jiménez Pérez
public class Books {
    private String title;
    private String author;
    private String imageUrl;

    public Books(String title, String author, String imageUrl) {
        this.title = title;
        this.author = author;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

