package com.example.hppc.model;

import java.util.List;

/**
 * Created by hppc on 25/06/2017.
 */

public class Plat {
    private String genre;
    private String designation;
    private int idPlat;
    private double prix;
    private String photo;
    private List reservations;


    public Plat() {
    }

    public Plat(String genre, String designation, int idPlat, double prix, String photo, List reservations) {
        this.genre = genre;
        this.designation = designation;
        this.idPlat = idPlat;
        this.prix = prix;
        this.photo = photo;
        this.reservations = reservations;
    }

    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }

    public List getReservations() {
        return reservations;
    }

    public void setReservations(List reservations) {
        this.reservations = reservations;
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
