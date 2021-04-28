package org.aslem.tp1banque;

public class Entreprise extends Client {
    private String siret;

    // COnstructeur d'une entreprise
    public Entreprise(String siret, String nom, String adresse) {
        super(nom, adresse);
        this.siret = siret;
    }
    
    
}
