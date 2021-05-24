package moodle;

import java.io.File;

public class Sujet {
	private File fichier;

	public Sujet(File fichier) {
		super();
		this.fichier = fichier;
	}

	public File getFichier() {
		return fichier;
	}

	public void setFichier(File fichier) {
		this.fichier = fichier;
	}
	
	
}
