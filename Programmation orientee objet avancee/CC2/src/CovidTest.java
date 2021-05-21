import java.time.LocalDate;
import java.util.Objects;

public class CovidTest implements Comparable<CovidTest>{
	private Personne personne;
	private Soignant testeur;
	private LocalDate dateTest;
	private boolean resultat;
	private TypeCovidTest typeCovidTest;
	
	// Constructeur
	public CovidTest(Personne reference, Soignant test, LocalDate dateTest, boolean resultat) {
		super();
		this.personne = reference;
		this.testeur = test;
		this.dateTest = dateTest;
		this.resultat = resultat;
	}
	
	public CovidTest(Personne reference, Soignant test, LocalDate dateTest, boolean resultat, TypeCovidTest typeCovidTest) {
		super();
		this.personne = reference;
		this.testeur = test;
		this.dateTest = dateTest;
		this.resultat = resultat;
		this.typeCovidTest = typeCovidTest;
	}
	
	public TypeCovidTest getTypeCovidTest() {
		return typeCovidTest;
	}

	// Getters - Setters
	public Personne donnePersonne() {
		return personne;
	}


	public void setPersonne(Personne reference) {
		this.personne = reference;
	}


	public Soignant donneTesteur() {
		return testeur;
	}


	public void setTest(Soignant test) {
		this.testeur = test;
	}


	public LocalDate donneDate() {
		return dateTest;
	}


	public void setDate(LocalDate dateTest) {
		this.dateTest = dateTest;
	}


	public boolean donneResultat() {
		return resultat;
	}


	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	// toString
	@Override
	public String toString() {
		return "CovidTest [reference=" + personne + ", test=" + testeur + ", dateTest=" + dateTest + ", resultat=" + resultat + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(dateTest, personne, resultat, testeur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CovidTest)) {
			return false;
		}
		CovidTest other = (CovidTest) obj;
		return Objects.equals(dateTest, other.dateTest) && Objects.equals(personne, other.personne)
				&& resultat == other.resultat && Objects.equals(testeur, other.testeur);
	}

	@Override
	public int compareTo(CovidTest o) {
		return -this.dateTest.compareTo(o.donneDate());
	}
}
