import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;

/**
 *
 * @author P. Rodriguez
 */
public class LecteurFichier {

    /* Attributs */
    private FileReader fic ;
    // Un StreamTokenizer est un curseur permettant de parcourir le contenu d'un fichier
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
     * Lit des personnes depuis le fichier nomFic
     * et retourne la collection des personnes.
     *
     * @return collection de personnes, lues dans le fichier choisi
     * @throws IOException
     */
    public ArrayList<Personne> lecture()throws IOException {
        ArrayList<Personne> buffer = new ArrayList<Personne>();
        entree.nextToken(); // Lecture de la première entrée
        while (entree.ttype!=StreamTokenizer.TT_EOF) {
            int id=(int) entree.nval;
            entree.nextToken();
            String nom = entree.sval;
            entree.nextToken();
            String prenom = entree.sval;
            entree.nextToken();
            char genre = entree.sval.charAt(0);
            entree.nextToken();
            int anneeNaiss = (int) entree.nval;
            entree.nextToken();
            String groupe = entree.sval;
            entree.nextToken();
            int categorie = (int) entree.nval;

            // Créer une nouvelle personne
            Personne p = new Personne(id, nom, prenom, genre, anneeNaiss, groupe, categorie); 
            buffer.add(p);
            System.out.println(p);
            entree.nextToken(); // Lecture de l'entrée suivante
        }
        return buffer;
    }
}