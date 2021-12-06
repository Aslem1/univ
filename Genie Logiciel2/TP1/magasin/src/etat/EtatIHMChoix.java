
package etat;

public class EtatIHMChoix extends EtatIHM{
    public EtatIHMChoix(Controleur controleur) {
        super(Controleur);
    }
    
    public void afficherMenu(){
        System.out.println("1 - Afficher les produits du catalogue");
        System.out.println("2 - Appliquer une promotion flash : -10% sur tous les produits");
        System.out.println("3 - Retour au menu precedent");
    } 
}