
public class Main {

	public static void main(String[] args) 
	{
		Produit p1 = new Produit("pomme");
		Produit p2 = new Produit("poire");
		Produit p3 = new Produit("raisin");
		
		Commande c1 = new Commande();
		c1.ajouterProduit(p1);
		c1.ajouterProduit(p2);
		c1.ajouterProduit(p3);
		c1.retirerProduit(p2);
		c1.etatSuivant();
		c1.ajouterProduit(p2);
		c1.retirerProduit(p3);
		c1.etatSuivant();
		c1.ajouterProduit(p2);
		c1.retirerProduit(p3);
		c1.etatSuivant();
	}

}
