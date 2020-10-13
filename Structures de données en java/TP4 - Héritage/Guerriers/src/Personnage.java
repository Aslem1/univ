/** CLASSE PERSONNAGE **/

public abstract class Personnage {
	//CONSTANTES -----------------------------------------
	//Type de personnages
	public static final int TYPE_CHEVALIER = 0;
	public static final int TYPE_EXCALIBUR = 1;
	public static final int TYPE_ENCHANTEUR = 2;
	public static final int TYPE_TRUQUEUR = 3;
	private final int NB_TYPES = 4;
	
	//Cibles possibles (partie 2 TP)
	public static final int CIBLE_TETE = 0;
	public static final int CIBLE_VENTRE = 1;
	public static final int CIBLE_JAMBES = 2;
	private final int NB_CIBLES = 3;
	//-----------------------------------------------------

	protected int vie; // parametre commun a tous les personnages
	protected int typePers;	// type du personnage creer selon constantes
	
	public int getVie() {
		return this.vie;
	}
	
	protected int Alea(int min, int max) { // tirage au sort entre min et max
            return  min +(int)(Math.random()*(max - min + 1));
	}
	
	public int getType() {	// renvoie le type de personnage selon les constantes
            return this.typePers;
	}

	public abstract int attaque();	// renvoie un entier proposionnel a la force de l'attaque
	public abstract void blesse();	// methode diminuant les parametres
        @Override
	public abstract String toString();// methode permettant d'afficher un personnage
	
        //Methode attaque
        public int getAttaque() {
            A = Alea[0, vie] + Alea[0,typePers] + Alea [0,typePers];
            return this.Alea(0, vie);
        }
        
        //Methode blessee
        public void getBlesse() {
            System.out.println("Vous êtes blessé" + vie - Alea(20,40));
        } 
        
        //Constructeurs
        public chevalier (int vie, int force, int courage){
            
        }
}

class  magicien {

}

class guerrier extends personnage {

}


class enchanteur {

}


class truqueur {

}

class chevalier {

}

class excalibur {


}
