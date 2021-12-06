import java.util.ArrayList;

public class Commande 
{
	private ArrayList<Produit> produits;
	private EtatCommande etatCommande;
	
	public Commande()
	{
		this.produits = new ArrayList<>();
		this.etatCommande = new CommandeEnCours(this);
	}
	
	public void ajouterProduit(Produit produit)
	{
		this.etatCommande.ajouterProduit(produit);
	}
	public void retirerProduit(Produit produit)
	{
		this.etatCommande.retirerProduit(produit);
	}
	public void etatSuivant()
	{
		this.etatCommande = this.etatCommande.etatSuivant();
	}
	
	public ArrayList<Produit> getProduits()
	{
		return this.produits;
	}
}
