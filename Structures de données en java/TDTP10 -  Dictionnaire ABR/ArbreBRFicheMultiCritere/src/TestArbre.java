import java.io.IOException;
import java.util.ArrayList;

public class TestArbre {
	public static void main( String [] args) {
            ArrayList <FicheClassement> tabClass = new ArrayList();
            ArrayList <FicheAnnee> tabAnnee = new ArrayList();
            ChargementDonnees c = new ChargementDonnees();          
           
            try{
                tabClass = c.chargementClassement();
            }catch( IOException e ) {System.out.println("pb lors du chargement");}
            
            // creation d'un ABR avec le classement comme relation d'ordre
            ArbreBR abrClassement = new ArbreBRVide();
            for (FicheClassement f : tabClass) {
                abrClassement= abrClassement.insereTo( f);
            }
            
            abrClassement.afficherGRD();            
            
            try {
                tabAnnee = c.chargementAnnee();
            } catch( IOException e ) {
                System.out.println("pb lors du chargement");
            }
            
            // creation d'un ABR avec le classement comme relation d'ordre
            ArbreBR abrAnnee = new ArbreBRVide();
            for (FicheAnnee f : tabAnnee) {
                abrAnnee= abrAnnee.insereTo( f);
            }
            
            abrAnnee.afficherGRD();
            System.out.println( abrAnnee.rechercherABR(tabAnnee.get(10)) );	
	}
}