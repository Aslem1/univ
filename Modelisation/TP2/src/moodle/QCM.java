package moodle;

import java.time.LocalDate;
import java.util.List;

public class QCM extends Devoir {
	private int nbQuestions;

	public QCM(List<Etudiant> presence, LocalDate dateRendu, boolean note, boolean retardAutorise,
			boolean analysePlagiat, Sujet sujet, int nbQuestions) {
		super(presence, dateRendu, note, retardAutorise, analysePlagiat, sujet);
		this.nbQuestions = nbQuestions;
	}

	public int getNbQuestions() {
		return nbQuestions;
	}

	public void setNbQuestions(int nbQuestions) {
		this.nbQuestions = nbQuestions;
	}

	
}
