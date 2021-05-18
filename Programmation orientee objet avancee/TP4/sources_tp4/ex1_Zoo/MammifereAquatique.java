/**
 * Classe représentant un mammifere aquatique caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore,
 * - un indicateur booleen precisant si le mammifere evolue dans l'eau douce.
 */
public class MammifereAquatique extends Mammifere {
   private boolean eauDouce;

   // Constructeur
    public MammifereAquatique(boolean eauDouce, String nomEspece, boolean carnivore) {
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
        return "MammifereAquatique{" + "eauDouce=" + eauDouce + '}';
    }

    // hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.eauDouce ? 1 : 0);
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
        final MammifereAquatique other = (MammifereAquatique) obj;
        if (this.eauDouce != other.eauDouce) {
            return false;
        }
        return true;
    }
    
    
   
}
