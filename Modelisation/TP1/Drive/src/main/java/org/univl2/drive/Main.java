package org.univl2.drive;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	public static final Logger logger = Logger.getGlobal();
	
	public static void main(String[] args) {
		/**
		 *  Creation des clients  
		**/
		Client client1 = new Client("Chevalier", "Maurice");
		logger.log(Level.INFO, "Nouveau " + client1);
		
		Client client2 = new Client("Martin", "Sophie");
		logger.log(Level.INFO, "Nouveau " + client2);
		
		/**
		 *  Creation du personnel  
		**/
		Personnel personnel1 = new Personnel("Pierre", "Alfred");
		personnel1.ajouterCreneau("Lundi", "08h30", "16h30");
		personnel1.ajouterCreneau("Mercredi", "08h30", "17h30");
		personnel1.ajouterCreneau("Jeudi", "08h30", "17h00");
		personnel1.ajouterCreneau("Vendredi", "08h30", "17h00");
		personnel1.ajouterCreneau("Samedi", "10h00", "20h00");
		logger.log(Level.INFO, "Nouveau " + personnel1);
		
		Personnel personnel2 = new Personnel("Jany", "Ahmed");
		personnel2.ajouterCreneau("Mardi", "08h30", "16h30");
		personnel2.ajouterCreneau("Mercredi", "08h30", "17h30");
		personnel2.ajouterCreneau("Jeudi", "08h30", "17h00");
		personnel2.ajouterCreneau("Vendredi", "08h30", "17h00");
		personnel2.ajouterCreneau("Samedi", "10h00", "20h00");
		logger.log(Level.INFO, "Nouveau " + personnel2);
		
		/**
		 *  Creation des produits  
		**/
		Produit produit1 = new Produit("pomme", 0.49);
		logger.log(Level.INFO, "Nouveau " + produit1);
		
		Produit produit2 = new Produit("jambon", 3.21);
		logger.log(Level.INFO, "Nouveau " + produit2);
		
		Produit produit3 = new Produit("brie", 2.34);
		logger.log(Level.INFO, "Nouveau " + produit3);
		
		/**
		 *  Creation des commandes
		 */
		Commande commande1 = GestionCommande.creerCommande(client1);
		logger.log(Level.INFO, "Nouvelle " + commande1);
		boolean res = GestionCommande.ajouterProduit(commande1, produit2, 4);
		logger.log(Level.INFO, "Modification " + commande1);
		if(!res) {
                    res = GestionCommande.ajouterProduit(commande1, produit3, 2);
                    logger.log(Level.INFO, "Modification " + commande1);
		}
		if(!res) {
                    res = GestionCommande.ajouterProduit(commande1, produit2, 1);
                    logger.log(Level.INFO, "Modification " + commande1);
		}
		if(res) {
                    GestionCommande.choixCreneau(commande1, "16/04/2021", "14h30");
                    logger.log(Level.INFO, "Modification " + commande1);
                    GestionCommande.validerCommande(commande1);
                    logger.log(Level.INFO, "Modification " + commande1);
                    GestionCommande.affecterPreparateur(commande1, personnel2, "16/04/2021", "13h45");
                    logger.log(Level.INFO, "Modification " + commande1);
                    GestionCommande.notifierPreparateur(commande1);
                    GestionCommande.recupererCommande(commande1);
                    logger.log(Level.INFO, "Modification " + commande1);
		} else {
                    GestionCommande.annulerCommande(commande1);
                    logger.log(Level.INFO, "Modification " + commande1);
		}
	}
}