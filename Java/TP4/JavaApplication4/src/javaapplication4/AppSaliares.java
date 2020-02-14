/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author csempe
 */
public class AppSaliares {

    
    public static void main(String[] args) throws IOException {
          // Déclaration d'un lecteur de fichiers
        LecteurFichier monLecteur;
        // Création du lecteur
	monLecteur = new LecteurFichier() ; 	
        // Choix du fichier manipulé par le lecteur
	monLecteur.choisirFichier("revenus.txt") ;

        ArrayList<Double> revenus; // Déclaration d'un arraylist pour récupérer les salaires.
	revenus = monLecteur.lectureReels(); // Lecture des noms dans le fichier et stockage dans le tableau
	// Vérification du nombre de revenus lus : 46.
        System.out.println(revenus.size());
        
        ArrayList<String> resultats = new ArrayList<String>();
        String unResultat = "Premier résultat : " + 1.0;
        resultats.add(unResultat);
	EnregistreurFichier monEF; // Déclaration d'un Enregistreur de fichiers
	monEF = new EnregistreurFichier();
	monEF.choisirFichier("resultats.txt");
	monEF.enregistrerArrayList(resultats);
        
        GestionSalaires gs;
        gs = new GestionSalaires (revenus);
        Double m = gs.min();
    }
    
}
