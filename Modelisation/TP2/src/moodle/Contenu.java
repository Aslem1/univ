package moodle;

import java.time.LocalDate;

public abstract class Contenu {
	private String nom;
	private LocalDate date;
	private Matiere matiere;
	private int duree;
	private Enseignant referent;

	public Contenu(String nom, LocalDate date, Matiere matiere, int duree, Enseignant referent) {
		super();
		this.nom = nom;
		this.date = date;
		this.matiere = matiere;
		this.duree = duree;
		this.referent = referent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	public Enseignant getReferent() {
		return referent;
	}

	public void setReferent(Enseignant referent) {
		this.referent = referent;
	}
}
