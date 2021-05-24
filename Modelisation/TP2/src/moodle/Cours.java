package moodle;

import java.time.LocalDate;

public class Cours extends Contenu {
	
	private String theme;

	public Cours(String nom, LocalDate date, Matiere matiere, int duree, Enseignant referent, String theme) {
		super(nom, date, matiere, duree, referent);
		this.theme = theme;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

}
