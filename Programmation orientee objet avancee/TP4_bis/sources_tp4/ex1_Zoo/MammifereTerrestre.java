/**
 * Classe représentant un mammifere terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore
 * - un nom d'habitat (biotope).
 */
public class MammifereTerrestre extends Mammifere {
   private String habitat;

	 
   // Constructeur
	public MammifereTerrestre(String nomEspece, boolean carnivore, String habitat) {
		super(nomEspece, carnivore);
		this.habitat = habitat;
	}


	// Getters - Setters
	public String getHabitat() {
		return habitat;
	}


	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}


	// toString
	@Override
	public String toString() {
		return "MammifereTerrestre [habitat=" + habitat + ", getNomEspece()=" + getNomEspece() + ", isCarnivore()="
				+ isCarnivore() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + "]";
	}


	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((habitat == null) ? 0 : habitat.hashCode());
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
		MammifereTerrestre other = (MammifereTerrestre) obj;
		if (habitat == null) {
			if (other.habitat != null)
				return false;
		} else if (!habitat.equals(other.habitat))
			return false;
		return true;
	}
}
