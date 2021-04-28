package org.aslem.bibliotheque;

public class EltMM {
    private String titre;
    private int duree;
    private boolean presentEnRayon;
    private String commentaires;

    //Constructeur
    public EltMM(String titre, int duree, boolean presentEnRayon, String commentaires) {
        this.titre = titre;
        this.duree = duree;
        this.presentEnRayon = presentEnRayon;
        this.commentaires = commentaires;
    }

    //Getter et setter
    
        /**
     * Donne le titre du CD.
     *
     * @return titre de l'element.
     */
    public String donneTitre() {
        return titre;
    }

        /**
     * Donne la dur&eacute;e du CD.
     *
     * @return dur&eacute;e du CD.
     */
    public int donneDuree() {
        return duree;
    }

       /**
     * @return true si le CD est en rayon.
     */
    public boolean donneEtatRayon() {
        return presentEnRayon;
    }

        /**
     * Fixe l'indicateur pour indiquer si le CD est dans la bibliotheque.
     * @param etat true si le CD est en rayon, false autrement.
     */
    public void changeEtatRayon(boolean etat) {
        this.presentEnRayon = etat;
    }

    /**
     * Donne les commentaires relatif au CD
     * 
     * @return Les commentaires de ce CD.
     */
    public String donneCommentaires() {
        return commentaires;
    }

        /**
     * Ajoute un commentaire au CD.
     * 
     * @param commentaires Les commentaires devant etre ajoutes.
     */
    public void ajouteCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    // toString
    @Override
    public String toString() {
        String s = "";
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
        return s;
    }
    
    
}
