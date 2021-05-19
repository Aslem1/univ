import java.time.LocalDate;

public class CovidTest implements Comparable<CovidTest>{
	private Personne personne;
	private Soignant testeur;
	private LocalDate dateTest;
	private boolean resultat;
	
	// Constructeur
	public CovidTest(Personne reference, Soignant test, LocalDate dateTest, boolean resultat) {
		super();
		this.personne = reference;
		this.testeur = test;
		this.dateTest = dateTest;
		this.resultat = resultat;
	}
	
	// - Setters
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
	
	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTest == null) ? 0 : dateTest.hashCode());
		result = prime * result + ((personne == null) ? 0 : personne.hashCode());
		result = prime * result + (resultat ? 1231 : 1237);
		result = prime * result + ((testeur == null) ? 0 : testeur.hashCode());
		return result;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CovidTest other = (CovidTest) obj;
		if (dateTest == null) {
			if (other.dateTest != null)
				return false;
		} else if (!dateTest.equals(other.dateTest))
			return false;
		if (personne == null) {
			if (other.personne != null)
				return false;
		} else if (!personne.equals(other.personne))
			return false;
		if (resultat != other.resultat)
			return false;
		if (testeur == null) {
			if (other.testeur != null)
				return false;
		} else if (!testeur.equals(other.testeur))
			return false;
		return true;
	}

	@Override
	public int compareTo(CovidTest o) {
		return -this.dateTest.compareTo(o.donneDate());
	}
}
