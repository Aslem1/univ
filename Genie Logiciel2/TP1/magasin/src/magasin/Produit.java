package magasin;

import commun.Observable;
import java.util.List;
import visiteur.Element;

public abstract class Produit extends Observable implements Element {

    //attributs privés de la classe abstraite Produit
    protected String idProduit;
    protected String nom;
    protected double prix;
    protected int dispo;

    //Constructeur du constructeur produit prenant en paramètre un tableau
    public Produit(String idProduit, String nom, double prix, int dispo) {
        super(); //Appelle le constructeur de la classe parent : observable
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.dispo = dispo;
    }
    //Foction toString()
    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", nom=" + nom + ", prix=" + prix + ", dispo=" + dispo + '}';
    }

    //Getters et Setters
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
    
    public void vendre (int nbProduit) {
        if (this.getDispo() > nbProduit) {
            this.dispo(this.getDispo(-nbProduit));
        }
    }
}