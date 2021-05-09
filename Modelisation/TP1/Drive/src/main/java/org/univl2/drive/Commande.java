package org.univl2.drive;

import java.util.List;

public class Commande {
    private int id;
    private String dateCommande;
    private double montantTotal;
    private String datePreparation;
    private String heurePreparation;
    private String dateLivraison;
    private String heureLivraison;
    private EtatCommande etat ;
    
    private Personnel preparateur;
    private Client client;
    
    private List<LigneCommande> lignesCommandes;
    
    // Constructeur
    public Commande(Client client) {
		super();
		this.client = client;
	}
    
    //ajouter un produit
    public void ajouterProduit (Produit produit, int quantite) {
    	
    }
    
    // getter preparateur
    public Personnel getPreparateur() {
        return preparateur;
    }
    

	// setter preparateur
    public void setPreparateur(Personnel preparateur) {
        this.preparateur = preparateur;
    }
    
    // setter date livraison
    public void setDateLivraison(String date, String heure) {
        this.dateLivraison = date;
        this.heureLivraison = heure;
    }
    
    // setter date préparation
    public void setDatePreparation(String date, String heure) {
        this.datePreparation = date;
        this.heurePreparation = heure;
    }
    
    // setter etat
    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }
    
}
