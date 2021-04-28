public abstract class Arbre {
    
	public abstract String getRacine(); 
	public abstract Arbre getAg(); 
	public abstract Arbre getAd(); 
	
	public abstract void setRacine(String s);
	public abstract void setAg(Arbre Ag);
	public abstract void setAd(Arbre Ad);
	
	
	public abstract boolean estVide();
		
	public abstract void afficheGRD();
	
	public abstract String lePlusAGauche();
	
	public abstract Arbre supprimer( String val );
	
	public abstract boolean trouver( String val );
	
	public abstract boolean estFeuille();
	
	public abstract int nbFeuilles();
	
	public abstract int nbNoeuds ();	
	
	public abstract int hauteur ();
	
	//public abstract boolean insereFeuille( String valeur);  //specif tournoi
	
	//public abstract void placerGagnant( String s);  // specif tournoi	

}

class ArbreVide extends Arbre {
    ArbreVide () {
    }

    @Override
    public String getRacine() { 
        return null; 
    }

    @Override
    public Arbre getAg() { 
        return this; 
    }

    @Override
    public Arbre getAd() { 
        return this; 
    }

    @Override
    public void setRacine(String s) {  
    }

    @Override
    public void setAg(Arbre Ag) {  
    }

    @Override
    public void setAd(Arbre Ad) {  
    }

    @Override
    public boolean estVide() {
            return true;
    }


    @Override
    public void afficheGRD() {
        System.out.println("Le plus à gauche : " +this.getAg());
        System.out.println("Est feuille : " +this.estFeuille());
        System.out.println("Nombre de feuilles : " +this.nbFeuilles());
        System.out.println("Nombre de noeuds : " +this.nbNoeuds());
        System.out.println("Hauteur : " +this.hauteur());
    }	


    @Override
    public boolean estFeuille() {
            return false;
    }


    @Override
    public int nbNoeuds () {
            return 0;	
    }

    @Override
    public int hauteur () {
            return 0;
    }

    public boolean trouve(String element) {
        return false;
    }
        
    @Override
    public String lePlusAGauche() {
        return "";
    }

    @Override
    public Arbre supprimer(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean trouver(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbFeuilles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class ArbreCons extends Arbre {
    private String racine;
    private Arbre Ag;
    private Arbre Ad;

    @Override
    public boolean estVide() {
            return false;
    }

    ArbreCons(String val, Arbre Ag, Arbre Ad) {
            this.racine = val; this.Ag = Ag; this.Ad = Ad;
    }

    ArbreCons( String val) {
            this.racine = val; this.Ag = new ArbreVide(); this.Ad = new ArbreVide();
    }

    @Override
    public String getRacine() { 
        return this.racine; 
    }

    @Override
    public Arbre getAg() { 
        return this.Ag; 
    }

    @Override
    public Arbre getAd() { 
        return this.Ad; 
    }

    @Override
    public void setRacine(String s) { 
        this.racine = s; 
    }

    @Override
    public void setAg(Arbre Ag) { 
        this.Ag = Ag; 
    }

    @Override
    public void setAd(Arbre Ad) { 
        this.Ad = Ad; 
    }



    @Override
    public boolean estFeuille() {
            return this.getAg().estVide() && this.getAd().estVide();
    }

    @Override
    public void afficheGRD() {
                    System.out.print( this.getRacine()+" " );
                    this.getAg().afficheGRD();
                    this.getAd().afficheGRD();
    }


    @Override
    public int nbNoeuds() {
                    int nfg = 0, nfd =0;
                    nfg = getAg().nbNoeuds();
                    nfd = getAd().nbNoeuds();
                    return (1 + nfg + nfd) ;
    }

    @Override
    public int hauteur() {
                    int nfg = 0, nfd = 0;
                    nfg = 1 + getAg().hauteur();
                    nfd = 1 + getAd().hauteur();
                    return Math.max(nfg, nfd) ;			
    }	


    @Override
    public int nbFeuilles() {
        if (this.estFeuille()) {
            return 1;
        }
        else {
            int nbFeuillesDroite = this.Ad.nbFeuilles();
            int nbFeuillesGauche = this.Ag.nbFeuilles();
            return (nbFeuillesDroite + nbFeuillesGauche);
        }
    }
        
    @Override
    public boolean trouver(String element) {
        if (this.racine.equals(element)) {
            return true;
        } else {
            return this.Ad.trouver(element) || this.Ag.trouver(element);
        }
    }
        
    //Faites une méthode qui donne l'élément le plus à droite dans l'arbre
    // public String lePlusAGauche ()
    @Override
     public String lePlusAGauche() {
         if(this.Ag instanceof ArbreVide){
             return this.racine;
         }
         return this.Ag.lePlusAGauche();
     }
                
    //Faites la méthode qui supprime un élément dans l'arbre public Arbre supprimer( String valeur )
    @Override
    public Arbre supprimer(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
}

