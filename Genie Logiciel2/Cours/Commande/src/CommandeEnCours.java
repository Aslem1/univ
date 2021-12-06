import java.util.logging.Level;

public class CommandeEnCours extends EtatCommande 
{

	public CommandeEnCours(Commande commande) 
	{
		super(commande);
	}

	@Override
	public void ajouterProduit(Produit produit) 
	{
		this.commande.getProduits().add(produit);
		log.log(Level.INFO, "Le produit {0} a ete ajoute a votre commande", produit);
	}

	@Override
	public void retirerProduit(Produit produit) 
	{
		this.commande.getProduits().remove(produit);
		log.log(Level.INFO, "Le produit {0} a ete retire de votre commande", produit);
	}

	@Override
	public EtatCommande etatSuivant() 
	{
		log.log(Level.INFO, "Votre commande est maintenant validee");
		return new CommandeValidee(this.commande);
	}
}
