package popotte;

public class Cuisine {

	public static void main(String[] args) {
		// Instancier un ingrédient carotte.
		Ingredient carotte = new Ingredient("Carotte", 26, 4.8, 0.20, 0.98);
		// Afficher tous les getters.
		System.out.println(carotte.getCalories());
		System.out.println(carotte.getGlucide());
		System.out.println(carotte.getLipide());
		System.out.println(carotte.getProteine());
		System.out.println(carotte.getNom());
		
		// Afficher la carotte avec toString.
		// 1ere méthode
		System.out.println(carotte.toString());
		
		//2eme méthode
		System.out.println(carotte);
		
		//Déclare et affecte un nouvel objet.
		Ingredient autre = carotte;
		
		//Teste l'égalité de carotte et autre avec "=="
		System.out.println(carotte == autre);
		
		//Teste l'égalité de carotte et autre avec "equals="
		System.out.println(carotte.equals(autre));
		
		//Instancie un objet d'une classe différente puis test avec la méthode equals
		Plat test = new Plat("test");
		System.out.println(carotte.equals(test));
		
		//Instancie un nouvel ingrédient, puis tester avec la méthode equals. 
		Ingredient pommeDeTerrre = new Ingredient("Pomme de terre", 85, 18.0, 0.1, 1.5);
		System.out.println(carotte.equals(pommeDeTerrre));
		
		//Instancier un nouvel ingredient portant le nom carotte et testez la méthode equals etl'egalité avec "=="
		Ingredient carotte2 = new Ingredient("CAROTTE", 0, 0, 0, 0);
		System.out.println(carotte.equals(carotte2));
		
		//Instancier le plat purée en utilisant le getteur sur le nom
		Plat puree = new Plat("Purée");
		System.out.println(puree.getNom());
		
		// Testez la méthode toString avec la purée qui ne contient aucun ingrédient.
		System.out.println(puree.toString());
		System.out.println(puree);
		
		//Test des plats
		Ingredient beurre = new Ingredient ("Beurre",100,4.0,1.0,2.0);
		Ingredient patates = new Ingredient ("Patates",200,2.5,4.5,2.5);
		Ingredient lait = new Ingredient ("Lait",300,8.0,4.0,6.0);
		Ingredient parmesan = new Ingredient ("Parmesan",800,1.0,5.0,4.0);
		puree.ajoute(lait, 200);
		puree.ajoute(parmesan, 40);
		puree.ajoute(patates, 400);
		puree.ajoute(beurre, 40);
		System.out.println(puree.getGlucide());
	}

}
