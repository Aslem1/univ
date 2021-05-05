
package org.aslem.bibliotheque;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main (String[] args) {
        BiblioMM biblio1 = new BiblioMM();
        
        // creation des cd/dvd
        CD cd1 = new CD("Swan Songs III", "Lord of the lost", 21, 2);
        DVD dvd1 = new DVD("Le seigneur des anneaux : La communauté de l'anneau", "Peter Jackson", 3);
        
        CD cd2 = new CD("Moby Dick", "Hans Zimmer", 10, 1);
        DVD dvd2 = new DVD("Moby Dick", "Herman Melville", 115);
        
        cd1.changeEtatRayon(true);
        
        // ajout des cd/dvd crées
        biblio1.ajouterEltMM(cd1);
        biblio1.ajouterEltMM(dvd1);
        
        biblio1.ajouterEltMM(cd2); // Ajout cd "moby dick"
        biblio1.ajouterEltMM(dvd2);
        
        // methode rechercherTitre()
        //System.out.println(biblio1.rechercherTitre("Swan Songs III"));
        
        // methode emprunterTitre(String titre)
        biblio1.emprunterTitre("Swan Songs III");
        
        // methode rechercherTitre()
        //System.out.println(biblio1.rechercherTitre("Swan Songs III"));
        
        //methode donneType()
        List<EltMM> elts = biblio1.rechercherTitre("Moby Dick");
        for(EltMM elt : elts) {
            
            System.out.println(elt.donneType());
            
            // Si l'element est un CD on apelle la methode donneArtiste()
            if(elt instanceof CD) {
                System.out.println(((CD) elt).donneArtiste());
            }
            
            // Si l'element est un DVD on apelle la methode donneRealisateur()
            if(elt instanceof DVD) {
                System.out.println(((DVD) elt).donneRealisateur());
            }
        }
    }
}
