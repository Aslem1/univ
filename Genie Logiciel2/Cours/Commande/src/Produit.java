
public class Produit
{
	private final String nom;
	
	public Produit(String nom)
	{
		this.nom = nom;
	}

	@Override
	public String toString() 
	{
		return "Produit [nom = " + nom + "]";
	}
}
