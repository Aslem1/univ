import java.util.Comparator;

public class ComparateurNomDetenteur implements Comparator<CompteBancaireInitial> {

	@Override
	public int compare(CompteBancaireInitial o1, CompteBancaireInitial o2) {
		// On compare 2 String alors on renvoie la comparaison de ces 2 String
		return o1.donneDetenteur().donneNom().compareTo(o2.donneDetenteur().donneNom());
	}

}
