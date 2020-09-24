package tp1donneesgps;

import java.io.IOException;


public class TP1DonneesGPS {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        /*Création de points puis affichage**/
        Point p1 = new Point (46.056425, -1.083614, 0, 12);
        Point p2 = new Point (46.056356, -1.083223, 5, 11);
        System.out.println(p1);
        System.out.println(p2);
        Parcours parcours = new Parcours("parcours");
        parcours.chargement();
        parcours.afficher();
        System.out.println(parcours.altitudeMax());
        System.out.println(parcours.temps());
        System.out.println(parcours.afficherVitesses());
    }
}