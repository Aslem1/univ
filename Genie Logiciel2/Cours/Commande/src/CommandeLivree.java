import java.util.logging.Level;

public class CommandeLivree extends EtatCommande 
{
	public CommandeLivree(Commande commande) 
	{
		super(commande);
	}

	@Override
	public void ajouterProduit(Produit produit) 
	{
		log.log(Level.INFO, "Le produit {0} ne peut etre ajoute a votre commande car elle est livree.", produit );
	}

	@Override
	public void retirerProduit(Produit produit) 
	{
		log.log(Level.INFO, "Le produit {0} ne peut etre ajoute a votre commande car elle est livree.", produit );
	}

	@Override
	public EtatCommande etatSuivant() 
	{
		log.log(Level.INFO, "Votre commande ne peut plus changer d''etat");
		return this;
	}
}
