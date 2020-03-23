package popotte;

import java.util.Objects;

/**
 * 
 * @author Agathe
 * @des0cription Informations et outils relatfs à un ingredient.
 *  
 */
public class Ingredient {
	/*
	 *Liste des attributs privés.S 
	 */
	private String nom;
	private long calories;
	private double glucide;
	private double lipide;
	private double proteine;
	
	/**
	 * Constructeur de la classe ingrédient.
	 * @param nom
	 * @param calories
	 * @param glucide
	 * @param lipide
	 * @param proteine
	 */
	public Ingredient(String nom, long calories, double glucide, double lipide, double proteine) {
		super();
		this.nom = nom;
		this.calories = calories;
		this.glucide = glucide;
		this.lipide = lipide;
		this.proteine = proteine;
	}
	
	/*/
	 * Liste des getter.
	 */
	public String getNom() {
		return nom;
	}
	
	public long getCalories() {
		return calories;
	}
	
	public double getGlucide() {
		return glucide;
	}
	
	public double getLipide() {
		return lipide;
	}
	
	public double getProteine() {
		return proteine;
	}
	
	
	/*/
	 * Convertit ingrédient en chaine de caractères. 
	 */
	@Override
	public String toString() {
		return "Ingredient [nom=" + nom + ", calories=" + calories + ", glucide=" + glucide + ", lipide=" + lipide
				+ ", proteine=" + proteine + "]";
	}
	
	/*
	 * Parce que equals.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}
	
	/*
	 * Méthode servant à tester l'égalité.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { //Test si les adresses mémoires sont égales.
			return true;
		}
		/*
		 * Si obj n'est pas de type ingrédient -> renvoi faux.
		 */
		if (!(obj instanceof Ingredient)) { 
			return false;
		}
		Ingredient other = (Ingredient) obj;
		return Objects.equals(nom, other.nom);
	}
}
