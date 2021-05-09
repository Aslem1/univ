package org.aslem.composantsinformatiques;

abstract class Composant {
    private int identifiant;
    private double prix;

    // COnstructeur
    public Composant(int identifiant, double prix) {
        this.identifiant = identifiant;
        this.prix = prix;
    }

    // Getter - Setter
    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    abstract public int donneEnergie();
}
