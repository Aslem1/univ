import java.time.LocalDate;

public class Patient extends Personne {
	private long numDossier;

	// Constructeur
	public Patient(String nom, String prenom, LocalDate dateNaissance, long numDossier) {
		super(nom, prenom, dateNaissance);
		this.numDossier = numDossier;
	}

	// Getters - Setters
	public long donneNumDossier() {
		return numDossier;
	}

	public void setNumDossier(long numDossier) {
		this.numDossier = numDossier;
	}

	// toString
	@Override
	public String toString() {
		return "Patient [numDossier=" + numDossier + ", getNom()=" + donneNom() + ", getPrenom()=" + donnePrenom()
				+ ", getDateNaissance()=" + donneDateNaissance() + ", toString()=" + super.toString() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + "]";
	}

	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (numDossier ^ (numDossier >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (numDossier != other.numDossier)
			return false;
		return true;
	}

	// Duree d'isolement d'un patient : 10 jours
	@Override
	public int dureeIsolement() {
		return 10;
	}
	
	
	
}
