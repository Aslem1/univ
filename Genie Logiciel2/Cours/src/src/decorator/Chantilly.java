package decorator;

import dessert.Dessert;

public class Chantilly extends DecorateurIngredient
{
	public Chantilly(Dessert dessert)
	{
		super(dessert);
	}

	@Override
	public String getLibelle() 
	{
		return this.dessert.getLibelle() + " chantilly";
	}

	@Override
	public double getPrix() 
	{
		return this.dessert.getPrix() + 0.4;
	}

	@Override
	public String toString() 
	{
		return this.dessert.getLibelle() + " chantilly, prix : " + (this.dessert.getPrix() + 0.4) + "€";
	}
}
