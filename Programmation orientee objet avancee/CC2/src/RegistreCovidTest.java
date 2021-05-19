import java.util.ArrayList;
import java.util.List;

public class RegistreCovidTest {
	private List<CovidTest> listeTest;
	
	// Constructeur
	public RegistreCovidTest() {
		super();
		this.listeTest = new ArrayList<>();
	}

	// Getter
	public List<CovidTest> donneListeTests() {
		return listeTest;
	}

	public boolean enregistrer(CovidTest test) {
		if(listeTest.contains(test)) {
			return false;
		} else {
			this.listeTest.add(test);
			return true;
		}
	}
}
