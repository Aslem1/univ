import java.util.ArrayList;

public abstract class ArbreBR 
{
	public abstract Fiche getRacine(); 
	public abstract ArbreBR getAg(); 
	public abstract ArbreBR getAd(); 
	
	public abstract void setRacine(Fiche s);
	public abstract void setAg(ArbreBR Ag);
	public abstract void setAd(ArbreBR Ad);
	
	public abstract ArbreBR insereTo( Fiche val );		
	
	public abstract boolean rechercherABR (Fiche val );
   
        public abstract Fiche rechercherRef (Fiche val );
	
	public abstract boolean estVide();
		
	public abstract void afficherGRD();
	
	public abstract Fiche lePlusAGauche();
	
	public abstract ArbreBR supprimer( Fiche val );
	
	public abstract boolean trouver( Fiche val );
	
	public abstract boolean estFeuille();
	
	public abstract int nbFeuilles();
	
	public abstract int nbNoeuds ();	
	
	public abstract int hauteur ();
	
	public abstract void arbreBREnTab (ArrayList t);
	

	
	
}
//----------------------------------------------------------------------
class ArbreBRVide extends ArbreBR   
{
	public ArbreBRVide ()
	{
	}
	
	public Fiche getRacine() { return null; }
	public ArbreBR getAg() { return this; }
	public ArbreBR getAd() { return this; }
	
	public void setRacine(Fiche s) {  }
	public void setAg(ArbreBR Ag) {  }
	public void setAd(ArbreBR Ad) {  }

	public ArbreBR insereTo( Fiche val )
	{
		return new ArbreBRCons(val);
	}
	
	public boolean rechercherABR (Fiche val )
	{
		return false;
	}
        public Fiche rechercherRef (Fiche val )
        {
           return null;
        }
	
	public boolean estVide()
	{
		return true;
	}

	
	public void afficherGRD()
	{
		// System.out.print(" vide ");
	}	
	
	public Fiche lePlusAGauche()
	{
	  return null;
	}
	
	public ArbreBR supprimer( Fiche val )
	{
		return this;
	}
	
	public boolean trouver( Fiche val )
	{
		return false;
	}

	public boolean estFeuille()
	{
		return false;
	}
	
	public int nbFeuilles()
	{
		return 0;
	}
	
	public int nbNoeuds ()
	{
		return 0;	
	}

	public int hauteur () {
		return 0;
	}
	
	public void arbreBREnTab (ArrayList t)
	{
	}
	
}

//----------------------------------------------------------------------

class ArbreBRCons extends ArbreBR
{
	private Fiche racine;
	private ArbreBR Ag;
	private ArbreBR Ad;
	
	public boolean estVide()
	{
		return false;
	}

	protected ArbreBRCons(Fiche val, ArbreBR Ag, ArbreBR Ad)
	{
		this.racine = val; this.Ag = Ag; this.Ad = Ad;
	}
	
	protected ArbreBRCons( Fiche val)
	{
		this.racine = val; this.Ag = new ArbreBRVide(); this.Ad = new ArbreBRVide();
	}

	public ArbreBRCons(ArrayList <Fiche> t, int d, int f)
	{
		if (d<f)
		{
			int milieu = (f + d)/2; 	// si 12,5 alors milieu=12
			if (milieu == d)				// cas d=2 f=3 milieu=2
			{
				this.racine= t.get(milieu); 
				this.Ag=new ArbreBRVide(); 
				this.Ad=new ArbreBRCons(t.get(milieu+1));
			}
			else
			{
				this.racine= t.get(milieu); 
				this.Ag=new ArbreBRCons( t, d, milieu-1); 
				this.Ad=new ArbreBRCons( t, milieu+1, f );
			}
		}
		else { this.racine= t.get(d); 	// cas d=f
				 this.Ag =new ArbreBRVide(); 
				 this.Ad =new ArbreBRVide();  }
	
	}
	
	public ArbreBR insereTo( Fiche val )
	{
		if ( !val.equals( this.getRacine() ) )
		{
			if (val.compareTo( getRacine() ) <0 )
					return new ArbreBRCons(this.getRacine(), this.getAg().insereTo( val ), this.getAd() );
			else	
					return new ArbreBRCons(this.getRacine(), this.getAg(), this.getAd().insereTo(val) );
		}
		return this;	
	}
	
	public Fiche getRacine() { return this.racine; }
	public ArbreBR getAg() { return this.Ag; }
	public ArbreBR getAd() { return this.Ad; }
	
	public void setRacine(Fiche s) { this.racine = s; }
	public void setAg(ArbreBR Ag) { this.Ag = Ag; }
	public void setAd(ArbreBR Ad) { this.Ad = Ad; }


	public boolean rechercherABR (Fiche val )  //rechercher dans un ABR
	{
		if (val.equals(this.getRacine()))
					return true;
		else
			if (val.compareTo( getRacine() ) <0 )
					return this.getAg().rechercherABR( val );
			else
					return this.getAd().rechercherABR( val );
	}

	public Fiche rechercherRef (Fiche val )  //rechercher dans un ABR
	{
		if (val.equals(this.getRacine()))
					return this.getRacine();
		else
			if (val.compareTo( this.getRacine() ) <0 )
					return this.getAg().rechercherRef( val );
			else
					return this.getAd().rechercherRef( val );
	}

   
   	
	public boolean estFeuille()
	{
		return this.getAg().estVide() && this.getAd().estVide();
	}

	
	public void afficherGRD()
	{
                        this.getAg().afficherGRD();
                        
			System.out.println( this.getRacine()+" " );
			
			this.getAd().afficherGRD();
	}
	
	public Fiche lePlusAGauche()
	{
		if (this.getAg().estVide()) return this.getRacine();
		else return this.getAg().lePlusAGauche();	
	}

	public ArbreBR supprimer( Fiche val )
	{
		if (val.equals(this.getRacine()))
		{
			if (this.getAd().estVide()) return this.getAg();  //cas particulier
			Fiche valeur = this.getAd().lePlusAGauche();
			return new ArbreBRCons( valeur , this.getAg() , this.getAd().supprimer(valeur)); 
		}	
		else
			if (val.compareTo( getRacine() ) <0 )
					return new ArbreBRCons(this.getRacine(), this.getAg().supprimer( val ), this.getAd() );
			else	
					return new ArbreBRCons(this.getRacine(), this.getAg(), this.getAd().supprimer(val) );

	}

	public boolean trouver( Fiche val )						//recherche dans tout l'arbre
	{
		if (val.equals(this.getRacine()))
					return true;
		else
			return this.getAg().trouver(val) || this.getAd().trouver(val);	
	
	}

	public int nbFeuilles()
	{
		if (this.estFeuille()) return 1;
		else
			return this.getAg().nbFeuilles()+this.getAd().nbFeuilles();
	}
	
	public int nbNoeuds()	{
			int nfg = 0, nfd =0;
			nfg = getAg().nbNoeuds();
			nfd = getAd().nbNoeuds();
			return (1 + nfg + nfd) ;
	}

	public int hauteur () {
			int nfg = 0, nfd = 0;
			nfg = 1 + getAg().hauteur();
			nfd = 1 + getAd().hauteur();
			return Math.max(nfg, nfd) ;			
	}

	public void arbreBREnTab (ArrayList t)
	{
		this.getAg().arbreBREnTab( t );
		t.add( this.getRacine() );
		this.getAd().arbreBREnTab( t );
	}
	
	
	
	
}

