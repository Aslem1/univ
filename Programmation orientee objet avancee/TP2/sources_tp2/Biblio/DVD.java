/**
 * La classe DVD represente un objet DVD. L'information sur le 
 * DVD est stockee et peut etre accedee. Nous considerons ici
 * uniquement les DVD Video.
 * 
 */
public class DVD
{
    private String titre;
    private String realisateur;
    private int duree;
    private boolean presentEnRayon;
    private String commentaires;

    /**
     * Initialise un DVD.
     * 
     * @param unTitre Le titre du DVD.
     * @param unArtiste Le nom de l'artiste du DVD.
     * @param uneDuree La duree du DVD.
     */
    public DVD(String unTitre, String unRealisateur, int uneDuree)
    {
        this.titre = unTitre;
        this.realisateur = unRealisateur;
        this.duree = uneDuree;
        this.presentEnRayon = false;
        this.commentaires = "<pas de commentaires>";
    }

    /**
     * Donne le titre du DVD.
     *
     * @return titre de l'element.
     */
    public String donneTitre()
    {
        return this.titre;
    }

    /**
     * Donne le nom du realisateur
     *
     * @return le nom du realisateur
     */
    public String donneRealisateur()
    {
        return this.realisateur;
    }

    /**
     * Donne la dur&eacute;e du DVD.
     *
     * @return dur&eacute;e du DVD.
     */
    public int donneDuree()
    {
        return this.duree;
    }

    /**
     * Fixe l'indicateur pour indiquer si le DVD est dans la bibliotheque.
     * @param etat true si le DVD est en rayon, false autrement.
     */
    public void changeEtatRayon(boolean etat)
    {
        this.presentEnRayon = etat;
    }

    /**
     * @return true si le DVD est en rayon.
     */
    public boolean donneEtatRayon()
    {
        return this.presentEnRayon;
    }

    /**
     * Ajoute un commentaire au DVD.
     * 
     * @param commentaires Les commentaires devant etre ajoutes.
     */
    public void ajouteCommentaires(String comment)
    {
        this.commentaires = comment;
    }

    /**
     * Donne les commentaires relatif au DVD
     * 
     * @return Les commentaires de ce DVD.
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
        String s = "\nDVD :\n";
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
        s += "Realisateur : " + this.realisateur + "\n";
        return s;
    }
}
