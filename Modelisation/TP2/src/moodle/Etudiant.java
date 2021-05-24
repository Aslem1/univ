package moodle;

public class Etudiant extends Participant {
	private int numEtudiant;

	public Etudiant(String nom, String prenom, String adresseEmail, int numEtudiant) {
		super(nom, prenom, adresseEmail);
		this.numEtudiant = numEtudiant;
	}

	public int getNumEtudiant() {
		return numEtudiant;
	}

	public void setNumEtudiant(int numEtudiant) {
		this.numEtudiant = numEtudiant;
	}
	
	public void deposerDevoir() {
		
	}
	
	public Devoir consulterDevoir() {
		return null;
	}
}
