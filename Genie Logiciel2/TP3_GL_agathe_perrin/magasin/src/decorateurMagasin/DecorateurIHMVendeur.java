package decorateurMagasin;

import magasin.Catalogue;

public class DecorateurIHMVendeur extends DecorateurIHM {
    public DecorateurIHMVendeur(AbstractionIHM abstraction) {
        super(abstraction);
    }

    @Override
    public void afficherMenu() {
        abstraction.afficherMenu();
        System.out.println("1 - Afficher les produits du catalogue");
        System.out.println("2 - Vendre un produit");
        System.out.println("3 - Retour a l'ecran precedent");
    }
    
    public void afficherSousMenu() {
        System.out.println("0 - Retour");
        System.out.println("1 - Vendre Rateau");
        System.out.println("2 - Vendre Boite clous");
        System.out.println("3 - Vendre Croquettes au poulet");
    }
}