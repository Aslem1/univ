import java.util.*;

public class Test {
    public static void main (String [] args) {
        Liste L1 = new ListeCons (10, new ListeCons(5, new ListeCons(8, new ListeCons(14, new ListeCons(27, new ListeCons (2, new ListeCons(65, new ListeVide() )))))));
        Liste L = L1.QS();
        L1.afficher();
        L.afficher();
    }
}
