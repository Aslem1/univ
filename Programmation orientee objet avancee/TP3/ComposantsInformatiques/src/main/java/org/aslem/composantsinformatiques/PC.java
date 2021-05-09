package org.aslem.composantsinformatiques;

import java.util.List;


public class PC {
    private List<Composant> composantsPc;

    // Constructeur
    public PC(List<Composant> composantsPc) {
        this.composantsPc = composantsPc;
        System.out.println("Je suis un pc");
    }

    // Getter - Setter
    public List<Composant> getComposantsPc() {
        return composantsPc;
    }

    public void setComposantsPc(List<Composant> composantsPc) {
        this.composantsPc = composantsPc;
    }

    @Override
    public String toString() {
        return "PC{" + "composantsPc=" + composantsPc + '}';
    }
    
    public static boolean testPuissance(List<Composant> composants) {
        int energieTotale = 0;
        for (Composant c : composants) {
            energieTotale += c.donneEnergie();
        }
        if (energieTotale < 0) {
            return false;
        } else {
            return true;
        } 
    }
}
