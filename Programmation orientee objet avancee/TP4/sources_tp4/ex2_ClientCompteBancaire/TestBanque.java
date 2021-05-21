import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestBanque {

	public static void main(String[] args) {
		
		// Création des clients
		Client client1 = new Client("Kennedy", "Leon");
		Client client2 = new Client("Redfield", "Claire");
		Client client3 = new Client("Valentine", "Jill");
		
		// Création des comptes banquaires
		CompteBancaireInitial compte1 = new CompteBancaireInitial(50.1, 123456, client1);
		CompteBancaireInitial compte2 = new CompteBancaireInitial(1000.2, 678910, client2);
		CompteBancaireInitial compte3 = new CompteBancaireInitial(9999.0, 1, client3);
		
		// Création d'une liste
		List<CompteBancaireInitial> listeComptes = new ArrayList<CompteBancaireInitial>();
		
		// Ajout des comptes dans la liste
		listeComptes.add(compte1);
		listeComptes.add(compte2);
		listeComptes.add(compte3);
		
		System.out.println("Liste avant tri : " + listeComptes);
		
		// Tri des comptes en utilisant la méthode Collections.sort
		Collections.sort(listeComptes);
		
		System.out.println("Liste après tri : " + listeComptes);
	}

}
