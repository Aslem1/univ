package org.aslem.tp1banque;

import java.util.ArrayList;

public class Client {
    private String nom;
    private String adresse;
    private ArrayList<CompteBancaire> comptes;

    // Constructeur
    public Client(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.comptes = new ArrayList<>();
    }
    
    // Methodes
    public boolean ajouteCompte(CompteBancaire compte) {
        if (compte.donneDetenteur() != null){
            this.comptes.add(compte);
            return true;
        } else {
            return false;
        }
    }
    
    // setAdresse
    public void changeAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    // getAdresse
    public String donneAdresse() {
        return this.adresse;
    }
    
    public String donneNom() {
        return this.nom;
    }
    
    public boolean supprimeCompte(int numCompte) {
        for(int i = 0; i < this.comptes.size(); i++) {
            CompteBancaire compte = this.comptes.get(i);
            if (compte.donneNumero() == numCompte) {
                this.comptes.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ", adresse=" + adresse + ", comptes=" + comptes + '}';
    }
    
    
}
