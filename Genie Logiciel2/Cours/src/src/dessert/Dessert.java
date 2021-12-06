package dessert;

public abstract class Dessert 
{
	protected String libelle;
	protected double prix;
	
	protected Dessert()
	{
		this.libelle = "";
		this.prix = 0.0;
	}

	@Override
	public String toString() 
	{
		return this.libelle + ", prix : " + prix + "€";
	}

	public String getLibelle() 
	{
		return this.libelle;
	}

	public double getPrix() 
	{
		return this.prix;
	}
}
