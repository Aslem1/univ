package org.aslem.composantsinformatiques;

public class Processor extends Composant {
    private int consommation;
    private int frequence;
    private String socket;

    // Constructeur
    public Processor(int consommation, int frequence, String socket, int identifiant, double prix) {
        super(identifiant, prix);
        this.consommation = consommation;
        this.frequence = frequence;
        this.socket = socket;
    }

    // Getter - Setter
    public int getConsommation() {
        return consommation;
    }

    public void setConsommation(int consommation) {
        this.consommation = consommation;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public int donneEnergie() {
        return -this.consommation;
    }

}
