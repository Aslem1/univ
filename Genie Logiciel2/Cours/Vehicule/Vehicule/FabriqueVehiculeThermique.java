package Vehicule;

public class FabriqueVehiculeThermique implements FabriqueVehicule
{

	@Override
	public Automobile creerAutomobile(String couleur) 
	{
		return new AutomobileThermique(couleur);
	}

	@Override
	public Scooter creerScooter(String modele) 
	{
		return new ScooterThermique(modele);
	}
}
