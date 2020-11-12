package liste;



public abstract class Liste  {
	public abstract boolean estVide();
        public abstract String getPremier();
        public abstract Liste getReste();
        
        public void afficherIT(){
            Liste list = this;
            
            while (!list.estVide()) {
                System.out.println(list.getPremier()+"");
                list = list.getReste();
            }
            System.out.println();
        };
        
        public boolean rechercherIT(String s) {
            Liste list = this;
            boolean reponse = false;
            while (!list.estVide() && (reponse == false)) {
                if (list.getPremier().equals(s)) {
                    reponse = true;
                }
                list = list.getReste();
            }
            return reponse;
        }
}

//************************************************************************************************************

  
class ListeVide extends Liste  {
	ListeVide () {
	}
	
	public boolean estVide() {
		return true;
	}
	
	public String getPremier() {
            return null;
        }
	
	public Liste getReste() {
            return null;
        }
        
        

}

//************************************************************************************************************

class ListeCons extends Liste {
	private String valeur;
	private Liste suiv;

	ListeCons(String val, Liste L) {
		this.valeur = val; this.suiv = L;
	}
	
	public boolean estVide() {
		return false;
	}

	public String getPremier() { 
            return this.valeur; 
        }
	
	public Liste getReste() { 
            return this.suiv; 
        }

}
