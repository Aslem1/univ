package moodle;

import java.util.List;

public class Conference extends Activite {
	private TypeConference type;

	public Conference(List<Etudiant> presence, TypeConference type) {
		super(presence);
		this.type = type;
	}

	public TypeConference getType() {
		return type;
	}

	public void setType(TypeConference type) {
		this.type = type;
	}
	

}
