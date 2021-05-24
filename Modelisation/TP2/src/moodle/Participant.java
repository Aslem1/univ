package moodle;

public abstract class Participant {
	private String nom;
	private String prenom;
	private String adresseEmail;
	
	public Participant(String nom, String prenom, String adresseEmail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresseEmail = adresseEmail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresseEmail() {
		return adresseEmail;
	}

	public void setAdresseEmail(String adresseEmail) {
		this.adresseEmail = adresseEmail;
	}
}
