/**
 * Classe représentant un reptile aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un indicateur booleen precisant si le reptile evolue dans l'eau douce.
 */
public class ReptileAquatique extends MammifereAquatique {
   private boolean venimeux;
   
   // Constructeur
   public ReptileAquatique(String nomEspece, boolean carnivore, boolean eauDouce, boolean venimeux) {
		super(nomEspece, carnivore, eauDouce);
		this.venimeux = venimeux;
	}

	// Getters - Setters
	public boolean isVenimeux() {
		return venimeux;
	}

	public void setVenimeux(boolean venimeux) {
		this.venimeux = venimeux;
	}

	// toString
	@Override
	public String toString() {
		return "ReptileAquatique [venimeux=" + venimeux + ", isEauDouce()=" + isEauDouce() + ", toString()="
				+ super.toString() + ", getNomEspece()=" + getNomEspece() + ", isCarnivore()=" + isCarnivore()
				+ ", getClass()=" + getClass() + "]";
	}

	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (venimeux ? 1231 : 1237);
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
		ReptileAquatique other = (ReptileAquatique) obj;
		if (venimeux != other.venimeux)
			return false;
		return true;
	}
}
