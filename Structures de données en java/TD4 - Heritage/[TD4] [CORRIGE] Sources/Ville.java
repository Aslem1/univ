public class Ville extends Commune {

    String nom;

    public Ville (int nbH, double s, String n) {
        super(nbH, s);
        this.nom = n;
    }

    @Override
    public double ratio() {
        return 0.8*super.ratio();
    }
}
