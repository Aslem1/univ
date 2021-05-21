import java.util.Comparator;

public class ComparateurMontantSolde implements Comparator<CompteBancaireInitial> {

	@Override
	public int compare(CompteBancaireInitial o1, CompteBancaireInitial o2) {
		// Si les deux objets sont égaux
		if (o1.donneSolde() == o2.donneSolde()) {
			return 0;
		} else if (o1.donneSolde() > o2.donneSolde()) { // Si o1 est supérieur à o2
			return 1;
		} else { // Si o1 est inférieur à o2
			return -1;
		}
	}

}
