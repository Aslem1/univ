/**
 * La classe CD represente un objet CD. 
 * 
 */
public class CD
{
    private String titre;
    private String artiste;
    private int nbPistes;
    private int duree;
    private boolean presentEnRayon;
    private String commentaires;

    /**
     * Initialise un CD.
     * 
     * @param unTitre Le titre du CD.
     * @param unArtiste Le nom de l'artiste du CD.
     * @param pistes Le nombre de pistes du CD.
     * @param uneDuree La duree du CD.
     */
    public CD(String unTitre, String unArtiste, int pistes, int uneDuree)
    {
        this.titre = unTitre;
        this.artiste = unArtiste;
        this.nbPistes = pistes;
        this.duree = uneDuree;
        this.presentEnRayon = false;
        this.commentaires = "<pas de commentaires>";
    }

    /**
     * Donne le titre du CD.
     *
     * @return titre de l'element.
     */
    public String donneTitre()
    {
        return this.titre;
    }

    /**
     * Donne le nom de l'artiste
     * 
     * @return nom de l'artiste
     */
    public String donneArtiste()
    {
        return this.artiste;
    }

    /**
     * Donne le nombre de pistes du CD.
     * 
     * @return nombre de pistes
     */
    public int donneNbPistes()
    {
        return this.nbPistes;
    }

    /**
     * Donne la dur&eacute;e du CD.
     *
     * @return dur&eacute;e du CD.
     */
    public int donneDuree()
    {
        return this.duree;
    }

    /**
     * Fixe l'indicateur pour indiquer si le CD est dans la bibliotheque.
     * @param etat true si le CD est en rayon, false autrement.
     */
    public void changeEtatRayon(boolean etat)
    {
        this.presentEnRayon = etat;
    }

    /**
     * @return true si le CD est en rayon.
     */
    public boolean donneEtatRayon()
    {
        return this.presentEnRayon;
    }

    /**
     * Ajoute un commentaire au CD.
     * 
     * @param commentaires Les commentaires devant etre ajoutes.
     */
    public void ajouteCommentaires(String commentaires)
    {
        this.commentaires = commentaires;
    }

    /**
     * Donne les commentaires relatif au CD
     * 
     * @return Les commentaires de ce CD.
     */
    public String donneCommentaires()
    {
        return this.commentaires;
    }

    /**
     * Renvoie une description textuelle de l'objet
     *
     * @return un chaine de caracteres decrivant l'objet
     */
    public String toString()
    {
        String s = "\nCD :\n";
        s += "Titre : " + this.titre + "\n";
        s += "Duree : " + this.duree + "\n";
        s += "Etat : ";
        if (this.presentEnRayon)
        {
            s += "disponible\n";
        }
        else
        {
            s += "emprunte\n";
        }
        s += "Commentaires : " + this.commentaires + "\n";
        s += "Artiste : " + this.artiste + "\npistes : " + this.nbPistes;
        return s;
    }
}
