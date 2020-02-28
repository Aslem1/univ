/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guerrier;

/**
 *
 * @author aperrin
 */
class Guerrier {
    // Attributs d'un Guerrier

    private String nom;
    private int force;
    private int sante;
    private int age;
    private int experience;

    // TODO Insérez les attributs ici
    // Attribut commun à tous les Guerriers (variable de classe)
    private static int nb = 0; // Nombre total de Guerriers créés

    // Constantes 
    private final static int FORCE_MIN = 1, FORCE_MAX = 5,
            SANTE_MIN = 0, SANTE_MAX = 100, LIMITE_FAIBLESSE = 40,
            IMPACT_BLESSURE = -10, // Perte de santé pour un combat perdu
            GAIN_EXPERIENCE = 1, // Gain d'expérience pour un combat remporté 
            EXPERIENCE_MIN = 0, EXPERIENCE_MAX = 10,
            AGE_MIN_DEPART = 20, AGE_MAX_DEPART = 50,
            LIMITE_JEUNESSE = 30, LIMITE_VIEILLESSE = 50,
            CHANCE_MAX = 10,
            DELTA_ETAT_RENF = 5, // Un guerrier dont l'état de santé s'améliore gagne ce nombre d'unité
            DELTA_ETAT_AFFAIBL = -7; // Un guerrier dont l'état de santé se détériore perd ce nombre d'unité
    private static final double CHANCE_RENF_JEUNE_SAIN = 0.6, // Un guerrier jeune et sain possède 60% de chance d'améliorer son état
            CHANCE_RENF_JEUNE_FAIBLE = 0.5,
            CHANCE_RENF_ADULTE_SAIN = 0.7,
            CHANCE_RENF_ADULTE_FAIBLE = 0.6,
            CHANCE_RENF_VIEUX_SAIN = 0.4,
            CHANCE_RENF_VIEUX_FAIBLE = 0.2;

    // Constructeur
    public Guerrier(String nom) {
        this.nom = nom;
        this.force = entierAleatoire(FORCE_MIN, FORCE_MAX);
        this.sante = sante(LIMITE_FAIBLESSE, SANTE_MAX);
        this.age = age(AGE_MIN_DEPART);
        this.experience = EXPERIENCE_MIN;
    }

    /* TODO-1 Initialisation aléatoire des attributs. 
   * Incrémentez l'attribut nb pour compter le nombre de guerriers créés
     */
    // TODO-2 Constructeur sans paramètre

    /**
     * ********** Méthodes *************
     */
    // Getteurs de niveau 1
    // TODO getForce et getExperience
    public int getForce() {
        return force;
    }

    public int getExperience() {
        return experience;
    }

    // Getteurs de niveau 2
    // TODO-1 estMort et estVivant
    public boolean getestVivant() {
        return true;
    }

    public boolean getestMort() {
        return true;
    }

    // TODO-2 estFaible
    // TODO-3 estJeune, estVieux, estAdulte
    // Setteurs de niveau 1
    // TODO modifierExperience et modifierSante
    // Setteurs de niveau 2
    // TODO-1 vieillir
    public void viellir() {
        age = age + 1;//fait vieillir le guerrier d'un an
    }

    // TODO-2 combattre
    public void combattre(Guerrier adversaire) {

    }

    // Autres
/*
  public void evoluer() {
    int delta = 0 ;
    if(this.estJeune()) {
      if(!this.estFaible()) {
        if(chance(CHANCE_RENF_JEUNE_SAIN)) {
          delta = DELTA_ETAT_RENF;
        } else {
          delta= DELTA_ETAT_AFFAIBL;
        }
      } else {
        if(chance(CHANCE_RENF_JEUNE_FAIBLE)) {
          delta = DELTA_ETAT_RENF; 
        } else {
          delta= DELTA_ETAT_AFFAIBL;
        }
      }
    }
    if(this.estAdulte()) {
      if(!this.estFaible()) {
        if(chance(CHANCE_RENF_ADULTE_SAIN)) {
          delta = DELTA_ETAT_RENF;
        } else {
          delta= DELTA_ETAT_AFFAIBL;
	} 
      } else {
	if(chance(CHANCE_RENF_ADULTE_FAIBLE)) {
          delta = DELTA_ETAT_RENF;
        } else {
          delta= DELTA_ETAT_AFFAIBL;
        }
      }
    }
    if(this.estVieux()) {
      if(!this.estFaible()) {
        if(chance(CHANCE_RENF_VIEUX_SAIN)) {
          delta = DELTA_ETAT_RENF;
        } else {
          delta= DELTA_ETAT_AFFAIBL;
        }
      } else {
        if(chance(CHANCE_RENF_VIEUX_FAIBLE)) {
          delta = DELTA_ETAT_RENF;
        } else {
          delta= DELTA_ETAT_AFFAIBL ;
        }
      }
    }
    this.modifierSante(delta) ;
  }
  /*********** Préparation à l'affichage  : méthode toString ******************/
    // TODO-1 toString
    @Override
    public String toString() {
        return null;
    }
    // TODO-2 affichage

    /**
     * ********** Outils locaux (private) *********************
     */
    private static boolean chance(double x) {
        return Math.random() < x;
    }

    private int entierAleatoire(int min, int max) {
        return (int) (min + (max + 1 - min) * Math.random());
    }
}
