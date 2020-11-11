package org.agathe.listechainee;

class ListeCons extends Liste {
    private String valeur;
    private Liste suiv;

    ListeCons(String val, Liste L) {
            this.valeur = val; this.suiv = L;
    }

    @Override
    public boolean estVide(){
            return false;
    }

    @Override
    public String getPremier() {
        return this.valeur;
    }

    @Override
    public Liste getReste() {
        return this.suiv;
    }

    @Override
    public void afficher(){
        System.out.print( this.getPremier() + " " );
        this.getReste().afficher();
    }
    
    @Override
    public int size(){
        return 1 + this.getReste().size();
    }

    @Override
    public String somme(){
        return this.getPremier() + " " + this.getReste().somme();
    }

    @Override
    public Liste copie(){
        return new ListeCons(this.getPremier(), this.getReste().copie());
    }
    
    @Override
    public boolean trouver(String val) {
        if (this.getPremier().equals(val)) {
            return true;
        } else {
            return this.getReste().trouver(val);
        }
    }

    @Override
    public Liste concat(Liste L1) {
        this.suiv = this.getReste().concat(L1);
        return this;
    }

    @Override
    public Liste inverser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Liste inserer(String s, int rang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
