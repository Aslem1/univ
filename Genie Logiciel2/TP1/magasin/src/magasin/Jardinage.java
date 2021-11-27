package magasin;

//La classe Jardinage hérite de la classe abstraite Produit

import visiteur.visiteurPromo;
import visiteur.visiteurStock;

public class Jardinage extends Produit {
    //l'attribut privé saison est un attribut propre à la classe jardinage
    private String saison;
    
    public Jardinage(String idProduit, String nom, double prix, int dispo, String saison) {
        //On super les attributs de la classe mère Produit
        super(idProduit, nom, prix, dispo);
        this.saison = saison;
    }
    
    //getters et setters

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    @Override
    public void accept(visiteurPromo v) {
        v.visit(this);
    }

    @Override
    public void accept(visiteurStock v) {
        v.visit(this);
    }
    
    
}
