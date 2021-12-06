package decorator;

import dessert.Dessert;

public abstract class DecorateurIngredient extends Dessert
{
	protected Dessert dessert;
	
	protected DecorateurIngredient(Dessert dessert)
	{
		this.dessert = dessert;
	}
	
	public abstract String getLibelle();
	public abstract double getPrix();
}
