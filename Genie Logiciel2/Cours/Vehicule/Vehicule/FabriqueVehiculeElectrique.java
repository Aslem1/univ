package Vehicule;

public class FabriqueVehiculeElectrique implements FabriqueVehicule
{

	@Override
	public Automobile creerAutomobile(String couleur) 
	{
		return new AutomobileElectrique(couleur);
	}

	@Override
	public Scooter creerScooter(String modele) 
	{
		return new ScooterElectrique(modele);
	}

}
