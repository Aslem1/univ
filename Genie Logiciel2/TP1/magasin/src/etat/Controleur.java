package etat;

import java.util.Scanner;

import magasin.Catalogue;

public class Controleur 
{
	private Catalogue catalogue;
	private EtatIhm etatIhm;
	
	public Controleur(Catalogue catalogue)
	{
		this.catalogue = catalogue;
		this.etatIhm = new EtatIhmChoix(this);
	}
	
	public void changeEtat(EtatIhm etat)
	{
		this.etatIhm = etat;
		this.etatIhm.afficherMenu(this.catalogue);
	}
	
	public void initMenu()
	{
		this.etatIhm = new EtatIhmChoix(this);
		this.etatIhm.afficherMenu(this.catalogue);
	}
	
	public int lireEntree()
	{
		@SuppressWarnings("resource")
		Scanner entree = new Scanner(System.in);
		int choix = entree.nextInt();
		//entree.close();
		return choix;
	}
}