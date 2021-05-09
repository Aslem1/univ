package org.aslem.composantsinformatiques;

public class MemoryBar extends Composant{
    private int frequence;
    private int consommation;

    // Constructeur
    public MemoryBar(int frequence, int consommation, int identifiant, double prix) {
        super(identifiant, prix);
        this.frequence = frequence;
        this.consommation = consommation;
    }

    // Getter - Setter
    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public int getConsommation() {
        return consommation;
    }

    public void setConsommation(int consommation) {
        this.consommation = consommation;
    }

    @Override
    public int donneEnergie() {
        return -this.consommation;
    }

}
