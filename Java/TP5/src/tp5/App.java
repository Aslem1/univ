
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5;

import java.util.ArrayList;

/**
 *
 * @author aperrin
 */
public class App {

    public static void main (String [] args){
        LigneDeCommande l1 = new LigneDeCommande (127, "pizza Campana", 2, 11.5 );
        LigneDeCommande l2 = new LigneDeCommande (5, "pizza Charcutière", 1, 12.5 );
        LigneDeCommande l3 = new LigneDeCommande (3, "pizza Marguerite", 2, 10.5 );
        LigneDeCommande 5 = new LigneDeCommande (15, "pizza 5 fromages", 3, 13.5 );
        
        //B.1 - Lecture à partir d'un fichier
        TraitementCommande Traitement = new TraitementCommande (); //objet de la classe TraitementCommande
        Traitement.afficher();
        
        System.out.println(l1.getArticle());
        System.out.println(l1.getNumero());
        
        ArrayList<LigneDeCommande> pizza = new ArrayList();
        pizza.add(l1);
        pizza.add(l2);
        pizza.add(l3);
        for (LigneDeCommande i: pizza){ //for each
            System.out.println(i);
        }
        System.out.println(Traitement.prixTotal());
        
        System.out.println(Traitement.prixTotalDeLaCommande(5));
        
        System.out.println(Traitement.afficherLaCommande(5));
        
        System.out.println(Traitement.lignesDeLaCommande(5));
        
        System.out.println(Traitement.lignesSansLaCommande(5));
    }
}
