package Vehicule;

public class ScooterThermique extends Scooter 
{
	public ScooterThermique(String modele)
	{
		super(modele);
	}

	@Override
	public void afficherCaracteristiques() 
	{
		System.out.println("Scooter thermique de modele : " + this.modele);
	}
}
