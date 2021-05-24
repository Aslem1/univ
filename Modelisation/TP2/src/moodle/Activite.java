package moodle;

import java.util.List;

public abstract class Activite {
	private List<Etudiant> presence;

	public Activite(List<Etudiant> presence) {
		super();
		this.presence = presence;
	}

	public List<Etudiant> getPresence() {
		return presence;
	}

	public void setPresence(List<Etudiant> presence) {
		this.presence = presence;
	}
	
}
