
package etat;

public class EtatIHMAdmin extends EtatIHM{
    public EtatIHMAdmin(Controleur controleur) {
        super(Controleur);
    }
    
    public void afficherMenu(){
        System.out.println("1 - Afficher les produits du catalogue");
        System.out.println("2 - Calculer la valeur du stock");
        System.out.println("3 - Generer le catalogue au format IHM");
        System.out.println("4 - Retour au menu precedent");
    }
}
