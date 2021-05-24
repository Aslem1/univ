package moodle;

import java.io.File;
import java.time.LocalDate;

public class Rendu {
	private Etudiant etudiant;
	private Devoir devoir;
	private LocalDate date;
	private File fichier;
	private Status status;
	private boolean plagiat;
	private double note;
	
	public Rendu(Etudiant etudiant, Devoir devoir, LocalDate date, File fichier, Status status, boolean plagiat,
			double note) {
		super();
		this.etudiant = etudiant;
		this.devoir = devoir;
		this.date = date;
		this.fichier = fichier;
		this.status = status;
		this.plagiat = plagiat;
		this.note = note;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Devoir getDevoir() {
		return devoir;
	}

	public void setDevoir(Devoir devoir) {
		this.devoir = devoir;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public File getFichier() {
		return fichier;
	}

	public void setFichier(File fichier) {
		this.fichier = fichier;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isPlagiat() {
		return plagiat;
	}

	public void setPlagiat(boolean plagiat) {
		this.plagiat = plagiat;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}
	
	
}
