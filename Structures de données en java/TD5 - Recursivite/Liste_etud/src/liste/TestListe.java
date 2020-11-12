package liste;

public class TestListe {
	public static void main( String [] args) {
            Liste L = new ListeCons("A", new ListeCons("B", new ListeCons("C", new ListeVide())));
            
            L.afficherIT();
            
            System.out.println(L.rechercherIT("C"));
	}
	
	
}