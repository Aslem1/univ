import java.util.Comparator;

public class TriTestParNom implements Comparator<CovidTest>{

	@Override
	public int compare(CovidTest o1, CovidTest o2) {
		return o1.donnePersonne().donneNom().compareTo(o2.donnePersonne().donneNom());
	}

}
