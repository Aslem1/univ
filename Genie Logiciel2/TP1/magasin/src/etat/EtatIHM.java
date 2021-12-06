
package etat;

public abstract class EtatIHM {
    private Controleur controleur;
    private Catalogue c;
    
    public EtatIHM(Controleur controleur) {
        this.controleur = controleur;
    }
    public void afficherMenu(Catalogue c) {
        System.out.println("0 - Quitter");
        System.out.println("1 - Interface administrateur");
        System.out.println("2 - Interface gestionnaire de stock");
        System.out.println("3 - Interface vendeur");
    }
}
