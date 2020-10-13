public class Peuplier extends Arbre {
    double taille;

    private Peuplier (double t) {
        super();
        this.taille = t;
    }

    static public Peuplier getInstance(double t) {
        if (compteur < 4) {
            compteur++;
            return new Peuplier(t);
        } else {
            return null;
        }
    }
    
    public void afficher() {
        System.out.println("Peuplier de taille " + taille);
    }
}
