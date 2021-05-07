package org.univl2.drive;

public class Personne {
    protected int id;
    protected String nom;
    protected String prenom;
    private int sld;

    // Constructeur
    protected Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getter nom
    public String getNom() {
        return nom;
    }
    
}
