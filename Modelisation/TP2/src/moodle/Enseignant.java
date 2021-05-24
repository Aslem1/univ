package moodle;

import java.util.List;

public class Enseignant extends Participant {
	private String numTelephone;

	public Enseignant(String nom, String prenom, String adresseEmail, String numTelephone) {
		super(nom, prenom, adresseEmail);
		this.numTelephone = numTelephone;
	}

	public String getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}
	
	public List<Rendu> consulterRendu() {
		return null;
	}
	
	public void attribuerNote() {
		
	}
	
	public void ajouterCommentaire() {
		
	}
	
	public void creerContenu() {
		
	}
}
