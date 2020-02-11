/**
 *
 * @author P. Rodriguez
 */
public class Personne {

    // Définition des attributs d'une personne
    private int id;
    private String nom;
    private String prenom;
    private char genre;
    private int anneeNaiss;
    private String groupe;
    private int categorie;
    private boolean estHomme;
    private boolean estFemme;

    /**
     * Constructeur de personne.
     *
     * @param lid : identifiant de la personne
     * @param leNom : nom de famille
     * @param lePrenom : prénom
     * @param leGenre : 'h', 'f', ...
     * @param lAnnee : année de naissance
     * @param leGroupe : groupe "Bosseur", "Surfeur", ...
     * @param laCategorie : catégorie
     */
    Personne(int lid, String leNom, String lePrenom, char leGenre, int lAnnee, String leGroupe,  int laCategorie) {
        this.id = lid;
        this.nom = leNom;
        this.prenom = lePrenom;
        this.genre = leGenre;
        this.anneeNaiss = lAnnee;
        this.groupe = leGroupe;
        this.categorie = laCategorie;
    }

    Personne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* Les getters */
    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public int getAnneeNaiss() {
        return this.anneeNaiss;
    }
    public String getGroupe() {
        return this.groupe;
    }
    public int getCategorie() {
        return this.categorie;
    }
    
    public boolean getestHomme (){
        if (genre == 'h'){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean getestFemme () {
        if (genre == 'f'){
            return true;
        }
        else {
            return false;
        }
    }
    
    /* Les setters */
    public void setGroupe(String leGroupe) {
        this.groupe = leGroupe;
    }
    public void setCategorie(int laCategorie) {
        this.categorie = laCategorie;
    }
    
    /* Affichage */
    public void afficher() {
	System.out.println(this.prenom + " " + this.nom + ", né.e en "
                + this.anneeNaiss + ", " + this.groupe + " de catégorie "
                + this.categorie);
    }
    
    @Override
    public String toString(){
        return this.prenom + " " + this.nom + ", né.e en "
                + this.anneeNaiss + ", " + this.groupe + " de catégorie "
                + this.categorie;
    }
    
    public boolean equals(Object p){
      if (p.getClass().equals(p)){
          return true;
      }
      return false;
    }

    boolean getlAnnee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
