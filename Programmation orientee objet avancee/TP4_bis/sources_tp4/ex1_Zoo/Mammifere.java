
public class Mammifere {
	   private String nomEspece;
	   private boolean carnivore;
	   
	// Constructeur   
	public Mammifere(String nomEspece, boolean carnivore) {
		super();
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
		return "Mammifere [nomEspece=" + nomEspece + ", carnivore=" + carnivore + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (carnivore ? 1231 : 1237);
		result = prime * result + ((nomEspece == null) ? 0 : nomEspece.hashCode());
		return result;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mammifere other = (Mammifere) obj;
		if (carnivore != other.carnivore)
			return false;
		if (nomEspece == null) {
			if (other.nomEspece != null)
				return false;
		} else if (!nomEspece.equals(other.nomEspece))
			return false;
		return true;
	}
}
