package Vehicule;

public abstract class Scooter 
{
	protected String modele;
	
	public Scooter(String modele)
	{
		this.modele = modele;
	}
	
	public abstract void afficherCaracteristiques();
}
