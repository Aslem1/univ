package org.aslem.composantsinformatiques;

public class Alimentation extends Composant{ 
    private int puissance;

    // Constructeur
    public Alimentation(int puissance, int identifiant, double prix) {
        super(identifiant, prix);
        this.puissance = puissance;
    }

    // Getter - Setter
    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    @Override
    public int donneEnergie() {
        return this.puissance;
    }
    
}
