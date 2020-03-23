package popotte;

import java.util.HashMap;

public class Plat {
	private String nom;
	private HashMap<Ingredient, Integer> ingredients;
	
	public Plat (String nom) {
		this.nom = nom;
		//Instanciation de la HashMap vide
		this.ingredients = new HashMap<>();
	}
	
	public Plat (String nom, HashMap<Ingredient, Integer> ingredients) {
		this.nom = nom;
		this.ingredients = ingredients;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajoute(Ingredient i, int qte) {
		if (ingredients.containsKey(i)) { //Si l'ingredient est deja dans la liste
			ingredients.replace(i, ingredients.get(i) + qte); //Renvoie la quantité précédente + celle ajoutée
		}
		else {
			this.ingredients.put(i, qte); //Ajoute l'ingredient si pas dans la liste
		}

	}
	
	public double getGlucide() {
		double totalGlucide = 0;
		for(Ingredient i: ingredients.keySet()) { //Pour tout ingrédient i dans la liste ingrédients
			totalGlucide += i.getGlucide()*ingredients.get(i)/100;
		}
		return totalGlucide;
	}
}
