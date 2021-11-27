package magasin;

import visiteur.visiteurPromo;
import visiteur.visiteurStock;

//Bricolage hérite de la classe abstraite produit
public class Bricolage extends Produit{
    //Attributs privés propres à la classe Bricolage
    private String rayon;
    private boolean electrique;
    
    public Bricolage(String idProduit, String nom, double prix, int dispo,String rayon,boolean electrique) {
        //On super les attributs de la classe mère Produit
        super(idProduit, nom, prix, dispo);
        this.rayon = rayon;
        this.electrique = electrique;
    }
    
    //getters et setters

    public String getRayon() {
        return rayon;
    }

    public void setRayon(String rayon) {
        this.rayon = rayon;
    }

    public boolean isElectrique() {
        return electrique;
    }

    public void setElectrique(boolean electrique) {
        this.electrique = electrique;
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
