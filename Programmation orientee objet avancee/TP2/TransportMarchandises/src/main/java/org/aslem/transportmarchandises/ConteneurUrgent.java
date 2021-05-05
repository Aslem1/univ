package org.aslem.transportmarchandises;

public class ConteneurUrgent extends Conteneur{
    private int poidsMax;
    
    //Constructeur
    public ConteneurUrgent(int poidsMax, int distance, int volumeMax) {
        super(distance, volumeMax);
        this.poidsMax = poidsMax;
    }
    
    // Vérifie que le colis respecte les contraintes du conteneur
    @Override
    public boolean conditionChargement (Colis c) {
        int volumeTotal = 0;
        
        for (Colis pkg : this.donneChargement()) { //pkg pour package
            volumeTotal += pkg.donneVolume(); 
        }
        
        if(c.donneVolume() + volumeTotal <= this.donneVolumeMax() && this.donnePoids() + c.donnePoids() <= this.poidsMax) {
            return true;
        } else {
            return false;
        }
    }
    
    // Calcul du cout du transport du conteneur : distance x poids 
    // Ici le cout total sera doublé
    @Override
    public int cout() {
        return super.cout()*2;
    }
    
}
