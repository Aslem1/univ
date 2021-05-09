package org.univl2.drive;

public class Commande implements GestionCommande{
    private int id;
    private String dateCommande;
    private double montantTotal;
    private String datePreparation;
    private String heurePreparation;
    private String dateLivraison;
    private String heureLivraison;
    private etat EtatCommande;
    
    private Personnel preparateur;
    private Client client;
    
    public LigneCommande[] getLigneCommande() {
        return this.LigneCommande;
    }
    
    //ajouter un produit

    // getter preparateur
    public Personnel getPreparateur() {
        return preparateur;
    }
    
    // setter preparateur
    public void setPreparateur(Personnel preparateur) {
        this.preparateur = preparateur;
    }
    
    // setter date livraison
    public void setDateLivraison(String dateLivraison) {
        this.dateLivraison = dateLivraison;
    }
    
    // setter date préparation
    public void setDatePreparation(String datePreparation) {
        this.datePreparation = datePreparation;
    }
    
    // setter etat
    public void setEtatCommande(etat EtatCommande) {
        this.EtatCommande = EtatCommande;
    }
    
}
