package org.agathe.listechainee;

public class ListeVide extends Liste { // permet d'avoir une sentinelle permettant d'idenfier une liste vide
    ListeVide () {
    }

    @Override
    public boolean estVide() {
            return true;
    }

    @Override
    public String getPremier(){
        return null;
    }

    @Override
    public Liste getReste(){
        return null;
    }


    @Override
    public void afficher(){
            System.out.println();
    }	

    @Override
    public String somme(){
            return "";
    }

    @Override
    public int size(){
            return 0;
    }

    @Override
    public Liste copie(){
            return new ListeVide();
    }

    @Override
    public boolean trouver(String val) {
        return false;
    }

    @Override
    public Liste concat(Liste L1) {
        return L1;
    }

    @Override
    public Liste inverser() {
        return new ListeVide();
    }

    @Override
    public Liste inserer(String s, int rang) {
        if (rang == 0) {
            return new ListeCons(s, new ListeVide());
        }
        return new ListeVide();
    }

    @Override
    public Liste intersection(Liste L) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Liste union(Liste L) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inclus(Liste L) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
