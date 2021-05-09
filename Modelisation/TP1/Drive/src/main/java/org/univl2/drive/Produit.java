package org.univl2.drive;

public class Produit {
    private int id;
    private String description;
    private double prix;
    private int sID;

    // Constructeur
    public Produit(String description, double prix) {
        this.description = description;
        this.prix = prix;
    }

    // getter description
    public String getDescription() {
        return description;
    }

    // getter prix
    public double getPrix() {
        return prix;
    }
    
}
