/**
 * Classe representant un client (dans le cadre de l'exercice sur le compte
 * bancaire).
 */
public class Client
{
    private String nom;
    private String prenom;

    public Client(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public String donneNom()
    {
        return this.nom;
    }
    
    public String toString()
    {
        return this.nom + " " + this.prenom;
    }
}
