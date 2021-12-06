package decorator;

import dessert.Dessert;

public class Chocolat extends DecorateurIngredient
{

	public Chocolat(Dessert dessert) 
	{
		super(dessert);
	}

	@Override
	public String getLibelle() 
	{
		return this.dessert.getLibelle() + " chocolat";
	}

	@Override
	public double getPrix() 
	{
		return this.dessert.getPrix() + 0.5;
	}
	
	@Override
	public String toString() 
	{
		return this.dessert.getLibelle() + " chocolat, prix : " + (this.dessert.getPrix() + 0.5 )+ "€";
	}
	
}
