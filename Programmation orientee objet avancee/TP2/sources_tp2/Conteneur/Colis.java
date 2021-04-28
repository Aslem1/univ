
/**
 * Represente un colis pouvant etre d'epos'e dans un conteneur.
 *
 */
public class Colis {

    private int poids;
    private int volume;
    private int numero;
    private static int nbColis = 0; // permet de donner un numero aux colis

    /**
     * Cr'ee un colis.
     *
     * @param poids poids en kg
     * @param volume volume en m3
     */
    public Colis(int poids, int volume) {
        this.poids = poids;
        this.volume = volume;
        this.numero = nbColis++;
    }

    /**
     * Retourne le poids du colis en kg
     *
     * @return le poids du colis
     */
    public int donnePoids() {
        return this.poids;
    }

    /**
     * Retourne le volume du colis en m3.
     *
     * @return le volume du colis
     */
    public int donneVolume() {
        return this.volume;
    }

    public String toString() {
        return "poids = " + this.poids + ", volume = " + this.volume;
    }

    /**
     * Compare deux colis
     * @param o l'autre colis
     * @return true si les deux colis sont identiques
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != Colis.class) {
            return false;
        } else {
            Colis c = (Colis) o;
            if (this.poids == c.poids 
                && this.volume == c.volume
                && this.numero == c.numero) {
                return true;
            } else {
                return false;
            }
        }
    }

}
