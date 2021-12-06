import java.util.logging.Level;

public class CommandeValidee extends EtatCommande 
{
	public CommandeValidee(Commande commande) 
	{
		super(commande);
	}

	@Override
	public void ajouterProduit(Produit produit) 
	{
		log.log(Level.INFO, "Le produit {0} ne peut etre ajoute a votre commande car elle est validee.", produit );
	}

	@Override
	public void retirerProduit(Produit produit) 
	{
		log.log(Level.INFO, "Le produit {0} ne peut ete ajoute a votre commande car elle est validee.", produit );
	}

	@Override
	public EtatCommande etatSuivant() 
	{
		log.log(Level.INFO, "Votre commande est livree.");
		return new CommandeLivree(this.commande);
		
	}
}
