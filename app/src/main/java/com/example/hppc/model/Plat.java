package com.example.hppc.model;

/**
 * Created by hppc on 25/06/2017.
 */

public class Plat {
    private String genre;
    private String designation;
    private double prix;
    private String photo;

    public Plat(){}
    public Plat(String genre, String designation, double prix, String photo) {
        this.genre = genre;
        this.designation = designation;
        this.prix = prix;
        this.photo = photo;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
