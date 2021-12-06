package Vehicule;

public abstract class Automobile 
{
	protected String couleur;
	
	public Automobile(String couleur)
	{
		this.couleur = couleur;
	}
	
	public abstract void afficherCaracteristiques();
}
