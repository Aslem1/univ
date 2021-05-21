/**
 * Classe représentant un reptile terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un nom d'habitat (biotope).
 */
public class ReptileTerrestre extends MammifereTerrestre {
   private boolean venimeux;
   
   // Constructeur
   public ReptileTerrestre(String nomEspece, boolean carnivore, String habitat, boolean venimeux) {
		super(nomEspece, carnivore, habitat);
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
		return "ReptileTerrestre [venimeux=" + venimeux + ", getHabitat()=" + getHabitat() + ", toString()="
				+ super.toString() + ", hashCode()=" + hashCode() + ", getNomEspece()=" + getNomEspece()
				+ ", isCarnivore()=" + isCarnivore() + ", getClass()=" + getClass() + "]";
	}

}
