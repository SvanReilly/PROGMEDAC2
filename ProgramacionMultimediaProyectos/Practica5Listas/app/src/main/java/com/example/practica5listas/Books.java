package com.example.practica5listas;
public class Books{
    private String title;
    private String author;
    private String frontCover;
    private String releaseDate;
    private String ISBNCode;

    public Books(String title, String author, String frontCover, String releaseDate, String ISBNCode) {
        this.title = title;
        this.author = author;
        this.frontCover = frontCover;
        this.releaseDate = releaseDate;
        this.ISBNCode = ISBNCode;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFrontCover() {
        return frontCover;
    }

    public void setFrontCover(String frontCover) {
        this.frontCover = frontCover;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(String ISBNCode) {
        this.ISBNCode = ISBNCode;
    }
}