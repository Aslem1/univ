import java.util.Objects;

public abstract class Mammifere {
   private String nomEspece;   
   private boolean carnivore;
   
   // Constructeur
    public Mammifere(String nomEspece, boolean carnivore) {
        this.nomEspece = nomEspece;
        this.carnivore = carnivore;
    }
    
    // Getters - Setters
    public String getNomEspece() {
        return nomEspece;
    }

    public void setNomEspece(String nomEspece) {
        this.nomEspece = nomEspece;
    }

    public boolean isCarnivore() {
        return carnivore;
    }

    public void setCarnivore(boolean carnivore) {
        this.carnivore = carnivore;
    }

    // toString
    @Override
    public String toString() {
        return "Mammifere{" + "nomEspece=" + nomEspece + ", carnivore=" + carnivore + '}';
    }

    // hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.nomEspece);
        hash = 83 * hash + (this.carnivore ? 1 : 0);
        return hash;
    }

    // Equals
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
        final Mammifere other = (Mammifere) obj;
        if (this.carnivore != other.carnivore) {
            return false;
        }
        if (!Objects.equals(this.nomEspece, other.nomEspece)) {
            return false;
        }
        return true;
    }
    
    
   
}
