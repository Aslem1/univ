import java.time.LocalDate;

public class Soignant extends Personne {
	private int numPS;

	// Constructeur
	public Soignant(String nom, String prenom, LocalDate dateNaissance, int numPS) {
		super(nom, prenom, dateNaissance);
		this.numPS = numPS;
	}

	// Getters - Setters
	public int donneNumPS() {
		return numPS;
	}

	public void setNumPS(int numPS) {
		this.numPS = numPS;
	}

	// toString
	@Override
	public String toString() {
		return "Soignant [numPS=" + numPS + ", getNom()=" + donneNom() + ", getPrenom()=" + donnePrenom()
				+ ", getDateNaissance()=" + donneDateNaissance() + ", toString()=" + super.toString() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + "]";
	}

	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numPS;
		return result;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Soignant other = (Soignant) obj;
		if (numPS != other.numPS)
			return false;
		return true;
	}
	
	
}
