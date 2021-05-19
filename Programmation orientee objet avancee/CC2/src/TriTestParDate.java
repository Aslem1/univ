import java.util.Comparator;

public class TriTestParDate implements Comparator<CovidTest>{

	@Override
	public int compare(CovidTest o1, CovidTest o2) {
		return o1.donneDate().compareTo(o2.donneDate());
	}
	
}
