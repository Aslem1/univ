import java.util.Objects;

/**
 *
 * @author jviaud
 */
public class Ingredient {
    
    /**
     * Nom de l'ingrédient.
     */
    private String nom;
    
    /**
     * Quantité en grammes de glucides pour 100g d'ingrédients.
     */
    private double glucide;
    
    /**
     * Quantité en grammes de protéines pour 100g d'ingrédients.
     */
    private double proteine;
    
    /**
     * Quantité en grammes de lipides pour 100g d'ingrédients.
     */
    private double lipide;
    
    /**
     * Quantité de kcal pour 100g d'ingrédients.
     */
    private long calories;

    /**
     * Constructeur.
     * 
     * @param nom de l'ingrédient
     * @param glucide apportés pour 100g
     * @param proteine apportés pour 100g
     * @param lipide apportés pour 100g
     * @param calories apportés pour 100g
     */
    public Ingredient(String nom, double glucide, double proteine, 
            double lipide, long calories) {
        this.nom = nom;
        this.glucide = glucide;
        this.proteine = proteine;
        this.lipide = lipide;
        this.calories = calories;
    }

    /**
     * Getter du nom de l'ingrédient.
     * 
     * @return nom de l'ingrédient
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de la quantité de glucides dans 100g d'ingrédient.
     * 
     * @return quantité de glucides
     */
    public double getGlucide() {
        return glucide;
    }

    /**
     * Getter de la quantité de protéines dans 100g d'ingrédient.
     * 
     * @return quantité de protéines
     */
    public double getProteine() {
        return proteine;
    }

    /**
     * Getter de la quantité de lipide dans 100g d'ingrédient.
     * 
     * @return quantité de lipide
     */
    public double getLipide() {
        return lipide;
    }

    /**
     * Getter de la quantité de calories dans 100g d'ingrédient.
     * 
     * @return quantité de calories
     */
    public long getCalories() {
        return calories;
    }

    /**
     * Egalité basée uniquement sur le nom.
     * 
     * @return vrai si et seulement si les ingrédients ont même nom.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingredient other = (Ingredient) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    /**
     * Caractéristiques de l'ingrédient sous forme de chaine.
     * 
     * @return version chaine de caractères de l'ingrédient.
     */
    @Override
    public String toString() {
        return "Ingredient{" + "nom=" + nom + ", glucide=" + glucide + 
                ", proteine=" + proteine + ", lipide=" + lipide + 
                ", calories=" + calories + '}';
    }

}
