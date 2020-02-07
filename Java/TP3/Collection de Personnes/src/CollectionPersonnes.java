
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jviaud
 */
public class CollectionPersonnes {
    private ArrayList<Personne> groupe;
    
    public CollectionPersonnes() throws IOException {
        LecteurFichier lf = new LecteurFichier();
        lf.choisirFichier("desPersonnes.txt");
        groupe = lf.lecture();
    }
    
    /* Affichage */
    public void afficher() {
	System.out.println(this.groupe);
    }
    
    public int effectifDeLAnnee (int annee){
        
        return 0;
        
            }
        }
}
