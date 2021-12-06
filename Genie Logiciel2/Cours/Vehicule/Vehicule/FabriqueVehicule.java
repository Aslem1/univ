package Vehicule;

public interface FabriqueVehicule 
{
	public Automobile creerAutomobile(String couleur);
	public Scooter creerScooter(String modele);
}
