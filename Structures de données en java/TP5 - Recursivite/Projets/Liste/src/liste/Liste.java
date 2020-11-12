package liste;



public abstract class Liste  
{	public abstract boolean estVide();
	public abstract String getPremier();
	public abstract Liste getReste();
		
	public abstract void afficher();
	
/*	public abstract int  size();
	
	public abstract String somme();
	
	public abstract Liste placerFin( String val);
	
	public abstract Liste copie();
	
	public abstract boolean trouver( String val );
	
	public abstract Liste concat( Liste L1 );
	
	public abstract Liste inverser();

	public abstract Liste inserer(String s , int rang );
	
	public abstract Liste intersection( Liste L );
	
	public abstract Liste union( Liste L );
	
	public abstract boolean inclus( Liste L );*/

	
}

//************************************************************************************************************
class ListeVide extends Liste   // permet d'avoir une sentinelle permettant d'idenfier une liste vide
{
	ListeVide ()
	{
	}
	
	public boolean estVide()
	{
		return true;
	}
	
	public String getPremier(){return null;}
	
	public Liste getReste(){return null;}

	
	public void afficher()
	{
		System.out.println();
	}	
	
	
	public String somme()
	{
		return "";
	}
	
	public int size()
	{
		return 0;
	}
	
	public Liste copie()
	{
		return new ListeVide();
	}

}


//**********************************************************************************************************
class ListeCons extends Liste
{
	private String valeur;
	private Liste suiv;

	ListeCons(String val, Liste L)
	{
		this.valeur = val; this.suiv = L;
	}
	
	public boolean estVide()
	{
		return false;
	}

	public String getPremier() { return this.valeur; }
	
	public Liste getReste() { return this.suiv; }
		
	
	public void afficher()
	{
			System.out.print( this.getPremier()+" " );
			this.getReste().afficher();
	}
	
	public int size()
	{
		return 0;
	}
	
	public String somme()
	{
		return "";
	}
		
	public Liste copie()
	{
		return this;
	}


}