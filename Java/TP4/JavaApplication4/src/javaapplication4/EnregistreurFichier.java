package javaapplication4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Cette classe permet de définir 
 * - les données nécessaires au fonctionnement d'un enregistreur de fichiers
 * - les opérations (méthodes) qu'un enregistreur de fichier peut effectuer
 * @author P. Rodriguez
 */
public class EnregistreurFichier {
    /**** DONNEES *******************/
    private String nomFic ;  // Pour stocker le nom du fichier à manipuler
    private FileWriter fic ;
    
    /** CONSTRUCTEUR = le programme exécuté lors de new EnregistreurFichier()
     * 
     * @throws java.io.IOException : envoie une erreur si l'accès au fichier pose un problème
     */
    
    public EnregistreurFichier() throws IOException {
    }

    /**
     *
     * @param nom : le chemin (si nécessaire), et le nom du fichier à enregistrer
     * @throws IOException : envoie une erreur si l'accès au fichier pose un problème
     */
    public EnregistreurFichier(String nom) throws IOException {
        this.nomFic = nom;
        this.fic = new FileWriter(this.nomFic);
    }

    /**
     * METHODES = opérations applicables aux enregistreurs de fichiers
     *
     * @param t : ArrayList à inscrire dans le fichier 
     * @throws java.io.IOException 
     */
    public void enregistrerArrayList(ArrayList t) throws IOException {
        for (int i = 0; i < t.size(); i++) {
            this.fic.write(t.get(i)+System.getProperty( "line.separator" ));
        }
        this.fic.close();
    }
    /**
     * Choisir le fichier manipulé
     * @param nom : chemin (eventuellement) et nom du fichier 
     * dans lequel l'enregistrement sera effectué
     * @throws IOException
     */
    public void choisirFichier(String nom) throws IOException {
        this.nomFic=nom ;
	this.fic = new FileWriter(this.nomFic);
    }
    
    /**
     *
     * @return le nom du fichier manipulé
     */
    public String getNomFic() {
        return this.nomFic;
    }
}
