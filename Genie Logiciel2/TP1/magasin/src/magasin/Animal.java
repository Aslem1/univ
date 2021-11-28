/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magasin;

import visiteur.VisiteurPromo;
import visiteur.VisiteurStock;

public class Animal extends Produit{
    private String animal;
    private double masse;
    
    public Animal(String idProduit, String nom, double prix, int dispo,String animal,double masse) {
        super(idProduit, nom, prix, dispo);
        this.animal = animal;
        this.masse = masse;
    }

    @Override
    public void accept(VisiteurPromo v) {
        v.visit(this);
    }

    @Override
    public void accept(VisiteurStock v) {
        v.visit(this);
    }
 
}
