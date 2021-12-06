package Vehicule;

public class AutomobileThermique extends Automobile 
{

	public AutomobileThermique(String couleur) 
	{
		super(couleur);
	}

	@Override
	public void afficherCaracteristiques() 
	{
		System.out.println("Automobile thermique de couleur : " + this.couleur);
	}

}
