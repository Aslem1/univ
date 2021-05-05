package org.aslem.transportmarchandises;

import java.util.ArrayList;
import java.util.List;

public class Conteneur {
    private int distance;
    private int volumeMax;

    // Creation d'une liste de colis
    private List<Colis> chargement;
    
    // Constructeur
    public Conteneur(int distance, int volumeMax) {
        this.distance = distance;
        this.volumeMax = volumeMax;
        this.chargement = new ArrayList<>();
    }
    
    // Permet d'ajouter un colis dans le conteneur
    public boolean ajout (Colis c) {
        if (conditionChargement(c)) {
            this.chargement.add(c);
            return true;
        } else {
            return false;
        }
    }
    
    // Vérifie que le colis respecte les contraintes du conteneur
    public boolean conditionChargement (Colis c) {
        int volumeTotal = 0;
        
        for (Colis pkg : this.chargement) { //pkg pour package
            volumeTotal += pkg.donneVolume(); 
        }
        
        if(c.donneVolume() + volumeTotal <= this.volumeMax) {
            return true;
        } else {
            return false;
        }
    }
    
    // Calcul du cout du transport du conteneur : distance x poids
    public int cout() {
        return this.distance * donnePoids();
    }
    
    // Retourne la distance à parcourir
    public int donneDistance() {
        return this.distance;
    }
    
    // Retourne le poids courant du conteneur
    public int donnePoids() {
        int poidsTotal = 0;
        
        for (Colis pkg : this.chargement) { //pkg pour package
            poidsTotal += pkg.donnePoids(); 
        }
        return poidsTotal;
    }
    
    // toString
    @Override
    public String toString() {
        return "Conteneur{" + "distance=" + distance + ", volumeMax=" + volumeMax + '}';
    }
    
    // Getter de chargement
    public List<Colis> donneChargement() {
        return chargement;
    }
    
    // Getter de volumeMax
    public int donneVolumeMax() {
        return volumeMax;
    }
    
    
    
}
