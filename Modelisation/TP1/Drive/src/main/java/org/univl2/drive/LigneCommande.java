package org.univl2.drive;

public class LigneCommande {
    private int quantite;
    private double montant;
    private Produit produit;

    // Constructeur
    public LigneCommande(Produit produit, int quantite) {
        this.quantite = quantite;
        this.produit = produit;
    }

    // Getter

    public double getMontant() {
        return montant;
    }
    
    public Produit getProduit() {
        return produit;
    }
    
    public int getQuantite() {
        return quantite;
    }
    
    // Setter
    public void setQuantite(int quantite) {
    	this.quantite = quantite;
    }
    
}
