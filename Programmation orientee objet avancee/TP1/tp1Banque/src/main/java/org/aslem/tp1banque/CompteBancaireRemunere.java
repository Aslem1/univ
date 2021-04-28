
package org.aslem.tp1banque;

public class CompteBancaireRemunere extends CompteBancaire {
    private final static double INTERET_PAR_DEFAUT = 0.03;
    private double tauxInteret;

    // Constructeur pour compte bancaire rémunéré
    public CompteBancaireRemunere(int numero, double soldeInitial, double tauxInteret, Client client) {
        super(numero, soldeInitial, client);
        this.tauxInteret = tauxInteret;
    }

    // Compte bancaire rémunéré dont le taux d'intéret est celui par defaut.
    public CompteBancaireRemunere(int numero, double soldeInitial, Client client) {
        super(numero, soldeInitial, client);
        this.tauxInteret = INTERET_PAR_DEFAUT;
    }

    // Compte bancaire rémunéré dont le taux d'interet est celui par defaut et dont le solde initial est à zéro.
    public CompteBancaireRemunere(int numero, Client client) {
        super(numero, 0, client);
        this.tauxInteret = INTERET_PAR_DEFAUT;
    }

    // Compte bancaire rémunéré avec attribution automatique d'un numéro.
    public CompteBancaireRemunere(double tauxInteret, double soldeInitial, Client client) {
        super(soldeInitial, client);
        this.tauxInteret = tauxInteret;
    }
    
    // Méthode crediterInteretMensuel : credite le compte des interets mensuels
    public void crediterInteretMensuel() {
        double resultat = this.consulter() * this.tauxInteret / 12;
        this.crediter(resultat);
    }

    @Override
    public String toString() {
        return "CompteBancaireRemunere{" + "tauxInteret=" + tauxInteret + '}';
    }
}
