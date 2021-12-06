import java.util.logging.Logger;

public abstract class EtatCommande 
{
	protected Commande commande;
	protected static Logger log = Logger.getLogger("log");
	
	protected EtatCommande(Commande commande)
	{
		this.commande = commande;
	}
	
	public abstract void ajouterProduit(Produit produit);
	public abstract void retirerProduit(Produit produit);
	public abstract EtatCommande etatSuivant();
}
