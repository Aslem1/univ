/**
 * Classe représentant un mammifere aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore,
 * - un indicateur booleen precisant si le mammifere evolue dans l'eau douce.
 */
public class MammifereAquatique extends Mammifere {
   private boolean eauDouce;

	// Constructeur
	public MammifereAquatique(String nomEspece, boolean carnivore, boolean eauDouce) {
		super(nomEspece, carnivore);
		this.eauDouce = eauDouce;
	}

	// Getters - Setters
	public boolean isEauDouce() {
		return eauDouce;
	}

	public void setEauDouce(boolean eauDouce) {
		this.eauDouce = eauDouce;
	}

	// toString
	@Override
	public String toString() {
		return "MammifereAquatique [eauDouce=" + eauDouce + ", getNomEspece()=" + getNomEspece() + ", isCarnivore()="
				+ isCarnivore() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + "]";
	}

	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (eauDouce ? 1231 : 1237);
		return result;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MammifereAquatique other = (MammifereAquatique) obj;
		if (eauDouce != other.eauDouce)
			return false;
		return true;
	}
	

   
	
}
