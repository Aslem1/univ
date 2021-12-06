package Vehicule;

public class AutomobileElectrique extends Automobile 
{

	public AutomobileElectrique(String couleur) 
	{
		super(couleur);
	}

	@Override
	public void afficherCaracteristiques() 
	{
		System.out.println("Automobile electrique de couleur : " + this.couleur);
	}
}
