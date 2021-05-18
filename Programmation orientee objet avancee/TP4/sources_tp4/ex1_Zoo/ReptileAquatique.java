/**
 * Classe représentant un reptile aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le reptile est venimeux,
 * - un indicateur booleen precisant si le reptile evolue dans l'eau douce.
 */
public class ReptileAquatique extends MammifereAquatique {
   private boolean venimeux;

   // Constructeur
    public ReptileAquatique(boolean venimeux, boolean eauDouce, String nomEspece, boolean carnivore) {
        super(eauDouce, nomEspece, carnivore);
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
        return "ReptileAquatique{" + "venimeux=" + venimeux + '}';
    }

    // hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.venimeux ? 1 : 0);
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
        final ReptileAquatique other = (ReptileAquatique) obj;
        if (this.venimeux != other.venimeux) {
            return false;
        }
        return true;
    }
    
    
   
}
