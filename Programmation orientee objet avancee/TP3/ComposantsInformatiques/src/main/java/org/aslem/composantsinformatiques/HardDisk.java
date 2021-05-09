package org.aslem.composantsinformatiques;

public class HardDisk extends Composant{
    private int consommation;
    private int capacite;
    
    // Constructeur
    public HardDisk(int consommation, int capacite, int identifiant, double prix) {
        super(identifiant, prix);
        this.consommation = consommation;
        this.capacite = capacite;
    }

    // Getter - Setter
    public int getConsommation() {
        return consommation;
    }

    public void setConsommation(int consommation) {
        this.consommation = consommation;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public int donneEnergie() {
        return -this.consommation;
    }
    
}
