
package org.aslem.bibliotheque;

public class Test {
    public static void main (String[] args) {
        BiblioMM biblio1 = new BiblioMM();
        
        // creation des cd/dvd
        CD cd1 = new CD("Swan Songs III", "Lord of the lost", 21, 2);
        DVD dvd1 = new DVD("Le seigneur des anneaux : La communauté de l'anneau", "Peter Jackson", 3);
        
        cd1.changeEtatRayon(true);
        
        // ajout des cd/dvd crées
        biblio1.ajouterEltMM(cd1);
        biblio1.ajouterEltMM(dvd1);
        
        // methode rechercherTitre()
        System.out.println(biblio1.rechercherTitre("Swan Songs III"));
        
        // methode emprunterTitre(String titre)
        biblio1.emprunterTitre("Swan Songs III");
        
        // methode rechercherTitre()
        System.out.println(biblio1.rechercherTitre("Swan Songs III"));
        
    }
}
