package moodle;

import java.time.LocalDate;
import java.util.List;

public class Devoir extends Activite {
	private LocalDate dateRendu;
	private boolean note;
	private boolean retardAutorise;
	private boolean analysePlagiat;
	private Sujet sujet;
	
	public Devoir(List<Etudiant> presence, LocalDate dateRendu, boolean note, boolean retardAutorise,
			boolean analysePlagiat, Sujet sujet) {
		super(presence);
		this.dateRendu = dateRendu;
		this.note = note;
		this.retardAutorise = retardAutorise;
		this.analysePlagiat = analysePlagiat;
		this.sujet = sujet;
	}

	public LocalDate getDateRendu() {
		return dateRendu;
	}

	public void setDateRendu(LocalDate dateRendu) {
		this.dateRendu = dateRendu;
	}

	public boolean isNote() {
		return note;
	}

	public void setNote(boolean note) {
		this.note = note;
	}

	public boolean isRetardAutorise() {
		return retardAutorise;
	}

	public void setRetardAutorise(boolean retardAutorise) {
		this.retardAutorise = retardAutorise;
	}

	public boolean isAnalysePlagiat() {
		return analysePlagiat;
	}

	public void setAnalysePlagiat(boolean analysePlagiat) {
		this.analysePlagiat = analysePlagiat;
	}

	public Sujet getSujet() {
		return sujet;
	}

	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}
	
	
}
