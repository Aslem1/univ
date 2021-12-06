package decorateurMagasin;

public class DecorateurIHMAdmin extends DecorateurIHM{

    public DecorateurIHMAdmin(AbstractionIHM abstraction) {
        super(abstraction);
    }

    @Override
    public void afficherMenu() {
        abstraction.afficherMenu();
        System.out.println("1 - Afficher les produits du catalogue");
        System.out.println("2 - Calculer la valeur du stock");
        System.out.println("3 - Generer le catalogue au format IHM");
        System.out.println("4 - Retour au menu precedent");
    }
}
