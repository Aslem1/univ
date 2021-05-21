/**
 * Classe représentant un reptile terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un nom d'habitat (biotope).
 */
public class ReptileTerrestre extends MammifereTerrestre{
   private boolean venimeux;

   // Constructeur
    public ReptileTerrestre(boolean venimeux, String habitat, String nomEspece, boolean carnivore) {
        super(habitat, nomEspece, carnivore);
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
        return "ReptileTerrestre{" + "venimeux=" + venimeux + '}';
    }

    // hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.venimeux ? 1 : 0);
        return hash;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReptileTerrestre other = (ReptileTerrestre) obj;
        if (this.venimeux != other.venimeux) {
            return false;
        }
        return true;
    }
    
    

}
