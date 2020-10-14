/**
 * Collection de UnLivre
 */


import java.io.*;
import java.util.ArrayList;


public class Bibliotheque {
    // votre structure de collection devra s'appeler  desLivres  pour pouvoir etre chargé par chargement()

    ArrayList<UnLivre> desLivres;
    int vueCourante;
    
    /**
     * Permet le chargement des Livres sous forme d'objets a partir d'un fichier
     * La structure de donnees desLivres est remplie
     * @param nomFichier
     * @throws IOException 
     */
    public void chargement( String nomFichier ) throws IOException {
  	String leTitre="",nomPhoto="", texte=""; int nbEx=-1;   // recuperation temporaire de ces infos
  	UnLivre unLivre;
        System.setProperty( "file.encoding", "UTF-8" );
 	        
        InputStreamReader fic = new InputStreamReader(new FileInputStream(nomFichier), "utf8");
	StreamTokenizer entree = new StreamTokenizer(fic);	// lecture par bloc de texte
	entree.quoteChar('"');
		
        // lecture des donnees dans le fichier connaissant le format-----------------------------
	int i =0;
	
        entree.nextToken() ;                    // premier element a traiter
	while ( entree.ttype != entree.TT_EOF ) { // c'est la fin du fichier ou pb ?   	  
            leTitre = entree.sval; 
            entree.nextToken() ;
            nomPhoto = entree.sval;
            entree.nextToken() ;
            texte = entree.sval;
            entree.nextToken() ;
            nbEx = (int) entree.nval;
            unLivre = new UnLivre( leTitre, nomPhoto, texte, nbEx ); // nouvel etudiant
            this.desLivres.add(unLivre);												// on ajoute
					
            i++;
            entree.nextToken() ;	
        }  // fin while
			
		
	fic.close();
    }

    public Bibliotheque() {
        this.desLivres = new ArrayList<>();
        this.vueCourante = 0;
    }

    public void ajouter(UnLivre e) {
        this.desLivres.add(e);
    }
    
    public int nbFilms() {
        return this.desLivres.size();
    }
    
    public void afficher() {
        for (int i = 0; i < this.desLivres.size(); i++) {
            System.out.println(this.desLivres.get(i));
        }
    }
    
    public void precedent() {
        this.vueCourante--;
        if (this.vueCourante < 0) {
            this.vueCourante = this.desLivres.size()-1;
        }
    }
    
    public void suivant() {
        this.vueCourante++;
        if (this.vueCourante == this.desLivres.size()) {
            this.vueCourante = 0;
        }
    }
    
    public void resetVue() {
        this.vueCourante = 0;
    }
    
    public UnLivre getLivre() {
        if (this.desLivres.isEmpty()){
            return null;
        }
        return this.desLivres.get(vueCourante);
    }
    
    public void emprunter() {
        UnLivre livre = this.desLivres.get(vueCourante);
        livre.setNbEmprunts(vueCourante);
    }
    
    public void rendre() {
        UnLivre livre = this.desLivres.get(vueCourante);
        livre.setRetour();
    }
    
    public void supprimer() {
        if (!this.desLivres.isEmpty()) {
            this.desLivres.remove(vueCourante);
            if (this.vueCourante == this.desLivres.size()) {
                this.vueCourante = 0;
            }
        }
    }
}