import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Personne {
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private boolean contamine;
	
	private List<CovidTest> depistagesEffectues;
	
	// Constructeur
	public Personne(String nom, String prenom, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.contamine = false;
		this.depistagesEffectues = new ArrayList<CovidTest>();
	}

	// Getters - Setters
	public String donneNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String donnePrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate donneDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean donneEtatContamination() {
		return contamine;
	}

	public void devientContamine(LocalDate date) {
		this.contamine = true;
	}

	// toString
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
	}

	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Personne other = (Personne) obj;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	// Création de la méthode dureeIsolement
	public abstract int dureeIsolement();
	
	public CovidTest seFaireDepister(LocalDate dateDepistage, Soignant soignant) {
		CovidTest test = new CovidTest(this, soignant, dateDepistage, contamine);
		depistagesEffectues.add(test);
		return test;
	}
	
	public CovidTest seFaireDepister(LocalDate dateDepistage, Soignant soignant, TypeCovidTest typeCovidTest) {
		CovidTest test = new CovidTest(this, soignant, dateDepistage, contamine, typeCovidTest);
		depistagesEffectues.add(test);
		return test;
	}
	
	public List<CovidTest> donneDepistagesEffectues() {
		Collections.sort(depistagesEffectues);
		return depistagesEffectues;
	}
}
