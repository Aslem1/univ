

public abstract class Arbre 
{
	public abstract String getRacine(); 
	public abstract Arbre getAg(); 
	public abstract Arbre getAd(); 
	
	public abstract void setRacine(String s);
	public abstract void setAg(Arbre Ag);
	public abstract void setAd(Arbre Ad);
	
	
	public abstract boolean estVide();
		

}

class ArbreVide extends Arbre   
{
	ArbreVide ()
	{
	}
	
	public String getRacine() { return null; }
	public Arbre getAg() { return this; }
	public Arbre getAd() { return this; }
	
	public void setRacine(String s) {  }
	public void setAg(Arbre Ag) {  }
	public void setAd(Arbre Ad) {  }

	public boolean estVide()
	{
		return true;
	}

	
	
}

class ArbreCons extends Arbre
{
	private String racine;
	private Arbre Ag;
	private Arbre Ad;
	
	ArbreCons(String val, Arbre Ag, Arbre Ad)
	{
		this.racine = val; this.Ag = Ag; this.Ad = Ad;
	}
	
	ArbreCons( String val)
	{
		this.racine = val; this.Ag = new ArbreVide(); this.Ad = new ArbreVide();
	}
	
	
	public String getRacine() { return this.racine; }
	public Arbre getAg() { return this.Ag; }
	public Arbre getAd() { return this.Ad; }
	
	public void setRacine(String s) { this.racine = s; }
	public void setAg(Arbre Ag) { this.Ag = Ag; }
	public void setAd(Arbre Ad) { this.Ad = Ad; }

	
        public boolean estVide()
	{
		return false;
	}
		
	public boolean estFeuille()
	{
		return this.getAg().estVide() && this.getAd().estVide();
	}
	

	
}

