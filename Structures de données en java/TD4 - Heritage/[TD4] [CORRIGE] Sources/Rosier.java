public class Rosier extends Arbre {
    
    private Rosier() {
        super();
    }

    static public Rosier getInstance() {
        if (compteur < 4) {
            compteur++;
            return new Rosier();
        } else {
            return null;
        }
    }
    
    public void afficher() {
        System.out.println("C'est juste un rosier");
    }
}
