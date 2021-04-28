
package org.aslem.tp1banque;

public class CompteBancaire {
    private static int numeroCompte = 0;
    private int numero;
    private double solde;
    private Client client;

    // Constructeurs
    public CompteBancaire(int numero, double soldeInitial, Client client) {
        this.numero = numero;
        this.solde = soldeInitial;
        this.client = client;
    }

    public CompteBancaire(double soldeInitial, Client client) {
        this.solde = soldeInitial;
        this.client = client;
        this.numero = numeroCompte;
        numeroCompte++; // Incrementation a chaque creation de compte
    }

    public CompteBancaire(int numero, Client client) {
        this.numero = numero;
        this.client = client;
    }
    
    // Méthodes
    public double consulter() {
        return solde;
    }
    
    public double crediter(double montant) {
        this.solde += montant; // += Pour this.solde = this.solde + montant
        return this.solde;
    }
    
    public double debiter(double montant) {
        this.solde -= montant; // -= Pour this.solde = this.solde - montant
        return this.solde;
    }
    
    public Client donneDetenteur() {
        return this.client;
    }
    
    public int donneNumero() {
        return this.numero;
    }
    
    public boolean transferer(CompteBancaire unCompte, int montantATransferer) {
        if (this.solde < montantATransferer) {
            this.debiter(montantATransferer);
            unCompte.crediter(montantATransferer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "CompteBancaire{" + "numero=" + numero + ", soldeInitial=" + solde + ", client=" + client + '}';
    }   
}
