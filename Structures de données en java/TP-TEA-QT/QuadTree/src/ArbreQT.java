public abstract class ArbreQT {
	public abastract void afficher();
        public abstract boolean equals(ArbreQt a);
}

class AQTVide extends ArbreQT {
	public AQTVide() {
}
        public void afficher() {
        }
}

class AQTCons extends ArbreQT {
    private ArbreQT nordOuest, nordEst, sudOuest, sudEst;
    
    public AQTCons(ArbreQT nordOuest, ArbreQT nordEst, ArbreQT sudOuest, ArbreQT sudEst) {
        this.nordOuest = nordOuest;
        this.nordEst = nordEst;
        this.sudOuest = sudOuest;
        this.sudEst = sudEst;
    }
    
    public ArbreQT getnordOuest() {
        return this.nordOuest;
    }
    
    public ArbreQT getnordEst() {
        return this.nordEst;
    }
    
    public ArbreQT getsudOuest() {
        return this.sudOuest;
    }
    
    public ArbreQT getsudEst() {
        return this.sudEst;
    }
    
    public void afficher() {
        System.out.println("");
        this.nordOuest.afficher();
        this.nordEst.afficher();
        this.sudOuest.afficher();
        this.sudEst.afficher();
        System.out.println("");
    }	 
}

class Blanc extends ArbreQT {
    public Blanc() {
    }
    
    public void afficher() {
        System.out.println("B");
    }
}

class Noir extends ArbreQT {
	public Noir() {
        }
        
        public void afficher() {
            System.out.println("N");
        }
}