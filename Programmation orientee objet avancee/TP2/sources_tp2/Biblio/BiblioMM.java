import java.util.ArrayList;

/**
 * La classe BiblioMM fournit un moyen de stocker des objets
 * CD et DVD. Une liste de tous les CD et DVD peut etre affichee
 * en mode texte.
 * 
 */
public class BiblioMM
{
    private ArrayList<CD> cds;
    private ArrayList<DVD> dvds;

    /**
     * Construit une bibliotheque vide.
     */
    public BiblioMM()
    {
        this.cds = new ArrayList<CD>();
        this.dvds = new ArrayList<DVD>();
    }

    /**
     * Ajoute un CD a la bibliotheque.
     * @param unCD Le CD a ajouter.
     */
    public void ajouterCD(CD unCD)
    {
        this.cds.add(unCD);
    }

    /**
     * Ajoute un DVD a la bibliotheque.
     * @param unDVD Le DVD a ajouter.
     */
    public void ajouterDVD(DVD unDVD)
    {
        this.dvds.add(unDVD);
    }

    /**
     * Affiche une liste de tous les CD et DVD actuellement dans
     * la bibliotheque.
     */
    public void affiche()
    {
        for(CD cd : this.cds) {
            System.out.println(cd);   
        }

        for(DVD dvd : this.dvds) {
            System.out.println(dvd);   
        }
    }
}
