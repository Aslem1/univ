
import java.util.ArrayList;

public class Arboriculture {
    public static void main(String[] args) {
        ArrayList<Arbre> foret = new ArrayList<Arbre>();
        Peuplier peuplier = Peuplier.getInstance(5.38);
        foret.add(peuplier);
        Pin pin = Pin.getInstance(12);
        foret.add(pin);
        Rosier rosier = Rosier.getInstance();
        foret.add(rosier);
        Peuplier peuplier2 = Peuplier.getInstance(6.85);
        foret.add(peuplier2);
        Pin pin2 = Pin.getInstance(8);
        foret.add(pin2);
        for (Arbre a : foret) {
            a.afficher();
        }
    }
}
