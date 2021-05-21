import java.util.Objects;

/**
 * Classe représentant un mammifere terrestre caracterise par :
 * - un nom d'espece,
 * - un indicateur booleen precisant si le mammifere est carnivore
 * - un nom d'habitat (biotope).
 */
public class MammifereTerrestre extends Mammifere {
   private String habitat;

   // Constructeur
    public MammifereTerrestre(String habitat, String nomEspece, boolean carnivore) {
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
        return "MammifereTerrestre{" + "habitat=" + habitat + '}';
    }

    // hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.habitat);
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
        final MammifereTerrestre other = (MammifereTerrestre) obj;
        if (!Objects.equals(this.habitat, other.habitat)) {
            return false;
        }
        return true;
    }
}
