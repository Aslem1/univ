import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import magasin.Catalogue;
import magasin.Produit;
import decorateurMagasin.DecorateurIHM;
import decorateurMagasin.DecorateurIHMAdmin;
import decorateurMagasin.DecorateurIHMChoixUtilisateur;
import decorateurMagasin.DecorateurIHMStock;
import decorateurMagasin.DecorateurIHMVendeur;
import decorateurMagasin.ImplementationIHM;
import fabriqueMagasin.SimpleFabrique;
import visiteurMagasin.VisitorPromoFlash;
import visiteurMagasin.VisitorValeurStock;

public class ClassePrincipale {
	private static Catalogue catalogue;
	private static ImplementationIHM implementationIHM;
	private static DecorateurIHM decorateur;
	private static Scanner entree;
	private static Logger log = Logger.getLogger("log");

	private static void afficherCatalogue() {
		log.log(Level.INFO, "\nLe catalogue contient : \n {0}", catalogue);
	}

	private static void gestionMenu() {
		entree = new Scanner(System.in);
		try {
			int choixMenu = -1;
			implementationIHM = new ImplementationIHM();
			decorateur = new DecorateurIHMChoixUtilisateur(implementationIHM);

			while (choixMenu != 0) {
				decorateur.afficherMenu();
				choixMenu = entree.nextInt();

				// Bidouille pour supprimer le nom des packages
				String[] listPackage = decorateur.getClass().toString().split("\\.");
				switch (listPackage[listPackage.length - 1]) {
				case "DecorateurIHMChoixUtilisateur":
					choixUtilisateur(choixMenu);
					break;
				case "DecorateurIHMAdmin":
					ihmAdmin(choixMenu);
					break;
				case "DecorateurIHMStock":
					ihmStock(choixMenu);
					break;
				case "DecorateurIHMVendeur":
					ihmVendeur(choixMenu);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		log.log(Level.INFO, "Fin");
	}

	private static void choixUtilisateur(int choixMenu) {
		switch (choixMenu) {
		case 1:
			decorateur = new DecorateurIHMAdmin(implementationIHM);
			break;
		case 2:
			decorateur = new DecorateurIHMStock(implementationIHM);
			break;
		case 3:
			decorateur = new DecorateurIHMVendeur(implementationIHM);
			break;
		default:
			break;
		}
	}

	private static void ihmAdmin(int choixMenu) {
		switch (choixMenu) {
		case 1:
			afficherCatalogue();
			break;
		case 2:
			catalogue.accept(new VisitorPromoFlash());
			break;
		case 3:
			decorateur = new DecorateurIHMChoixUtilisateur(implementationIHM);
			break;
		default:
			break;
		}
	}

	private static void ihmStock(int choixMenu) {
		switch (choixMenu) {
		case 1:
			afficherCatalogue();
			break;
		case 2:
			catalogue.accept(new VisitorValeurStock());
			break;
		case 3:
			catalogue.sauvegardeCatalogue("index.html");
			break;
		case 4:
			decorateur = new DecorateurIHMChoixUtilisateur(implementationIHM);
			break;
		default:
			break;
		}
	}

	private static void ihmVendeur(int choixMenu) {
		switch (choixMenu) {
		case 1:
			afficherCatalogue();
			break;
		case 2:
			// Choix du produit a vendre
			while (choixMenu != 0) {
				((DecorateurIHMVendeur) decorateur).afficherSousMenu(catalogue);
				choixMenu = entree.nextInt();
				Produit p = catalogue.getProduit(choixMenu);
				if (p != null)
					p.vendre(1);
				else
					decorateur = new DecorateurIHMVendeur(implementationIHM);
			}
			// Pour eviter de quitter le programme
			choixMenu = -1;
			break;
		case 3:
			decorateur = new DecorateurIHMChoixUtilisateur(implementationIHM);
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		SimpleFabrique simpleFabrique = new SimpleFabrique();
		catalogue = new Catalogue();
		Path path = Paths.get("catalogue.txt");
		String ligne;

		try (BufferedReader lecteurAvecBuffer = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
			while ((ligne = lecteurAvecBuffer.readLine()) != null)
				catalogue.addProd(simpleFabrique.creerProduit(ligne));
		} catch (Exception exc) {
			log.log(Level.SEVERE, "Erreur à la lecture du fichier de stock {0}: ", exc.getMessage());
		}
		gestionMenu();
	}
}
