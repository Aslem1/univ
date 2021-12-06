
package etat;

public class EtatIHMStock extends EtatIHM{

    public EtatIHMStock(Controleur controleur) {
        super(controleur);
    }
    
    public void afficherMenu() {
        System.out.println("0 - Quitter");
        System.out.println("1 - Afficher les produits du catalogue");
        System.out.println("2 - Calculer la valeur du stock");
        System.out.println("3 - Generer le catalogue au format HTML");
        System.out.println("4 - Retour au menu precedent");
    }
}
