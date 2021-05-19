/**
 * Classe representant un compte bancaire.
 */
public class CompteBancaireInitial
{
    private double solde;
    private int numero;
    private Client detenteur;

    // constructeur permettant d'initialiser le solde
    // du compte, le numero et le proprietaire du compte
    public CompteBancaireInitial(double soldeInitial, int numero, Client c)
    {
        this.solde = soldeInitial;
        this.numero = numero;
        this.detenteur = c;
    }

    public int donneNumero()
    {
        return this.numero;
    }

    public double donneSolde()
    {
        return this.solde;
    }

    public Client donneDetenteur()
    {
        return this.detenteur;
    }

    // credite un compte d'un montant donne
    public void crediter(double montant)
    {
        this.solde = this.solde + montant;
    }

    // debite un compte d'un montant donne
    public double debiter(double montant)
    {
        this.solde = this.solde - montant;
        return montant;
    }

    // donne le solde du compte
    public double consulter()
    {
        return this.solde;
    }

    // transfert un montant du courant courant vers le compte de destination
    public void transferer(CompteBancaireInitial unCompte, int montantATransferer)
    {
        this.solde = this.solde - montantATransferer;
        unCompte.solde = unCompte.solde + montantATransferer;
    }

    // affichage
    public String toString()
    {
        return this.numero + " " + this.solde + " " + this.detenteur;
    }
}
