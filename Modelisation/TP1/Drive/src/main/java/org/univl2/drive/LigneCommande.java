package org.univl2.drive;

public class LigneCommande extends Produit implements GestionCommande {
    private int quantite;
    private double montant;
    private Commande commande;

    // Constructeur
    public LigneCommande(int quantite, double montant) {
        this.quantite = quantite;
        this.montant = montant;
    }

    // Getter

    public int getQuantite() {
        return quantite;
    }

    public double getMontant() {
        return montant;
    }

    public Produit getProduit() {
        return null; //TODO modifier return
    }
    
}
