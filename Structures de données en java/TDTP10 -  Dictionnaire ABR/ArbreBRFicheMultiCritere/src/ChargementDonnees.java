
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;



public class ChargementDonnees {
    
    public ChargementDonnees() {        
    }
    
    /**
     * Permet de charger les données et de retourner un tableau de FicheClassement
     * La relation d'ordre implementé dans FicheClassement est le classement du jeu
     * @return
     * @throws IOException 
     */
    public ArrayList <FicheClassement> chargementClassement( )throws IOException
    {
            String leTitre="",plateforme="";   // recuperation temporaire de ces infos
            int annee; int classement; double ventes;
            ArrayList <FicheClassement> tabClass = new ArrayList();
            
            System.setProperty( "file.encoding", "UTF-8" );
            //FileReader fic = new FileReader(nomFichier);            // ouverture du fichier

            InputStreamReader fic = new InputStreamReader(new FileInputStream("Basejeuxvideos.txt"), "utf8");
            StreamTokenizer entree = new StreamTokenizer(fic);	// lecture par bloc de texte
            entree.quoteChar('"');

            // lecture des donnees dans le fichier connaissant le format-----------------------------
            int i =0;

            entree.nextToken() ;                    // premier element a traiter
            while ( entree.ttype != entree.TT_EOF ) // c'est la fin du fichier ou pb ?
            {  	  
                classement = (int) entree.nval;
                entree.nextToken() ;
                leTitre = entree.sval; 
                entree.nextToken() ;
                annee = (int) entree.nval;
                entree.nextToken() ;
                plateforme = entree.sval;
                entree.nextToken() ;
                ventes = entree.nval;
                
                FicheClassement f = new FicheClassement( classement, leTitre, annee, plateforme, ventes ); // nouvel etudiant
                tabClass.add(f);												// on ajoute

                i++;
                entree.nextToken() ;	
            }  // fin while


            fic.close();
            return tabClass;
    }
    /**
     * Permet de charger les données et de retourner un tableau de FicheAnnee
     * La relation d'ordre implementé dans FicheAnnee est l'annee du jeu
     * @return
     * @throws IOException 
     */
    public ArrayList <FicheAnnee> chargementAnnee( )throws IOException
    {
            String leTitre="",plateforme="";   // recuperation temporaire de ces infos
            int annee; int classement; double ventes;
            ArrayList <FicheAnnee> tabAnnee = new ArrayList();
            
            System.setProperty( "file.encoding", "UTF-8" );
            //FileReader fic = new FileReader(nomFichier);            // ouverture du fichier

            InputStreamReader fic = new InputStreamReader(new FileInputStream("Basejeuxvideos.txt"), "utf8");
            StreamTokenizer entree = new StreamTokenizer(fic);	// lecture par bloc de texte
            entree.quoteChar('"');

            // lecture des donnees dans le fichier connaissant le format-----------------------------
            int i =0;

            entree.nextToken() ;                    // premier element a traiter
            while ( entree.ttype != entree.TT_EOF ) // c'est la fin du fichier ou pb ?
            {  	  
                classement = (int) entree.nval;
                entree.nextToken() ;
                leTitre = entree.sval; 
                entree.nextToken() ;
                annee = (int) entree.nval;
                entree.nextToken() ;
                plateforme = entree.sval;
                entree.nextToken() ;
                ventes = entree.nval;
                
                FicheAnnee f = new FicheAnnee( classement, leTitre, annee, plateforme, ventes ); // nouvel etudiant
                tabAnnee.add(f);												// on ajoute

                i++;
                entree.nextToken() ;	
            }  // fin while


            fic.close();
            return tabAnnee;
    }
    
    
}
