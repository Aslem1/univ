package javaapplication4;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;


/**
 *
 * @author P. Rodriguez
 */
public class LecteurFichier {
    /*** Attributs ****************/
    private FileReader fic ;
    private StreamTokenizer entree ;
   
    /**
     * Constructeur.
     */
    public LecteurFichier() {
    //System.out.println("Je suis le constructeur de la classe \"LecteurFichier\"") ;
    }
   
    /**
     * Choix du fichier à lire.
     *
     * @param nomFichier : le nom de fichier que ce lecteur de fichier permettra de lire
     * @throws IOException : envoie une erreur si l'accès au fichier pose un problème
     */
    public void choisirFichier(String nomFichier) throws IOException {
        fic = new FileReader(nomFichier);
        entree =new StreamTokenizer(this.fic);
    }
   
    /**
     * Lecture du fichier.
     * 
     * @return un tableau de réel, ceux lus dans le fichier choisi
     * @throws IOException
     */
    public ArrayList<Double> lectureReels()throws IOException {
        // Lit des réels depuis le fichier nomFic, et renvoie un tableau de réels
        ArrayList<Double> buffer = new ArrayList<Double>();
        entree.nextToken(); // Lecture de la première entrée
        while (entree.ttype!=StreamTokenizer.TT_EOF) {
            buffer.add(entree.nval);
            // System.out.print(entree.nval) ;
            entree.nextToken(); // Lecture de l'entrée suivante
        }
        return buffer;
    }
}