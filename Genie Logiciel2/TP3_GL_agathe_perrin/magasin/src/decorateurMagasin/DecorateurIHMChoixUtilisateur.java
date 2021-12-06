package decorateurMagasin;

public class DecorateurIHMChoixUtilisateur extends DecorateurIHM {

    public DecorateurIHMChoixUtilisateur(AbstractionIHM abstraction) {
        super(abstraction);
    }

    @Override
    public void afficherMenu() {
        abstraction.afficherMenu();
        System.out.println("1 - Afficher les produits du catalogue");
        System.out.println("2 - Appliquer une promotion flash : -10% sur tous les produits");
        System.out.println("3 - Retour au menu precedent");
    }
}
