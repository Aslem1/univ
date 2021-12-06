package decorateurMagasin;

public class DecorateurIHMStock extends DecorateurIHM{

    public DecorateurIHMStock(AbstractionIHM abstraction) {
        super(abstraction);
    }
    
    @Override
    public void afficherMenu() {
        abstraction.afficherMenu();
        System.out.println("1 - Interface administrateur");
        System.out.println("2 - Interface gestionnaire de stock");
        System.out.println("3 - Interface vendeur");
    }
}