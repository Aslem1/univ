package Vehicule;

public class ScooterElectrique extends Scooter 
{

	public ScooterElectrique(String modele) 
	{
		super(modele);
	}

	@Override
	public void afficherCaracteristiques() 
	{
		System.out.println("Scooter electrique de modele : " + this.modele);
	}
}
