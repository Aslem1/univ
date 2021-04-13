package org.aslem.tp1banque;

public class Particulier extends Client {
    private String prenom;

    // Constructeur d'un particulier
    public Particulier(String prenom, String nom, String adresse) {
        super(nom, adresse);
        this.prenom = prenom;
    }
    
    
}
