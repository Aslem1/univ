import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author jviaud
 */
public class Plat {

    // -----------------------------------------------------------------------
    // CHAMPS
    // -----------------------------------------------------------------------
    
    /**
     * Nom du plat.
     */
    private String nom;

    /**
     * Quantité requise en grammes de l'ingrédient dans la recette.
     */
    private HashMap<Ingredient, Integer> ingredients;

    // -----------------------------------------------------------------------
    // CONSTRUCTEURS
    // -----------------------------------------------------------------------

    /**
     * Constructeur sans ingrédients.
     *
     * @param n du plat
     */
    public Plat(final String n) {
        this.nom = n;
        this.ingredients = new HashMap<Ingredient, Integer>();
    }

    /**
     * Constructeur avec nom et ingrédients.
     * 
     * @param nom du plat
     * @param ingredients et leur quantité présents dans le plat 
     */
    public Plat(String nom, HashMap<Ingredient, Integer> ingredients) {
        this.nom = nom;
        this.ingredients = (HashMap<Ingredient, Integer>) ingredients.clone();
    }

    // -----------------------------------------------------------------------
    // GETTERS
    // -----------------------------------------------------------------------

    /**
     * Getter du nom du plat.
     * 
     * @return le nom du plat
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter des ingrédients et leur quantités présents dans le plat.
     * 
     * @return ingrédients et leur quantités
     */
    public HashMap<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    /**
     * Getter de la quantité de glucides dans le plat.
     * 
     * @return quantité de glucides
     */
    public double getGlucide() {
        double total = 0.0;
        // Parcours des ingrédients avec un "foreach"
        for (Ingredient i : this.ingredients.keySet()) {
            total += this.ingredients.get(i)*i.getGlucide()/100;
        }
        return total;
    }

    /**
     * Getter de la quantité de proteines dans le plat.
     * 
     * @return quantité de protéines
     */
    public double getProteine() {
        double total = 0.0;
        // Parcours des ingrédients avec un "foreach"
        for (Ingredient i : this.ingredients.keySet()) {
            total += this.ingredients.get(i)*i.getProteine()/100;
        }
        return total;    }

    /**
     * Getter de la quantité de lipides dans le plat.
     * 
     * @return quantité de lipides
     */
    public double getLipide() {
        double total = 0.0;
        // Parcours des ingrédients avec un "foreach"
        for (Ingredient i : this.ingredients.keySet()) {
            total += this.ingredients.get(i)*i.getLipide()/100;
        }
        return total;
    }
    
    /**
     * Getter de la quantité de calories dans le plat.
     * 
     * @return quantité de calories
     */
    public long getCalories() {
        long total = 0;
        // Parcours des ingrédients avec un "foreach"
        for (Ingredient i : this.ingredients.keySet()) {
            total += this.ingredients.get(i)*i.getCalories()/100;
        }
        return total;
    }

    // -----------------------------------------------------------------------
    // SETTER
    // -----------------------------------------------------------------------

    /**
     * Ajoute un ingrédient dans le plat.
     * Si l'ingrédient est déjà présent dans le plat, alors seule la quantité
     * est augmentée.
     *
     * @param i ingrédient à ajouter
     * @param qte quantité de l'ingrédient à ajouter
     */
    public void ajoute(Ingredient i, Integer qte) {
        if (this.ingredients.containsKey(i)) {
            this.ingredients.replace(i, this.ingredients.get(i) + qte);
        } else {
            this.ingredients.put(i, qte);
        }
    }

    // -----------------------------------------------------------------------
    // AUTRES METHODES
    // -----------------------------------------------------------------------

    /**
     * Caractéristique du plat : nom, ingrédients et quantité.
     * 
     * @return version chaine de caractère du plat
     */
    @Override
    public String toString() {
        String s = "Plat{" + "nom=" + nom + ", glucide=" + this.getGlucide() + 
                ", proteine=" + this.getProteine() + ", lipide=" + 
                this.getLipide() + ", calories=" + this.getCalories() + "}\n";
        // Parcours des ingrédients avec un "foreach"
        for (Ingredient i : this.ingredients.keySet()) {
            s += '\t' + i.toString() + '\n';
        }
        return s;
    }

    /**
     * Ingrédient le plus calorique du plat.
     * 
     * @return l'ingrédient le plus calorique
     */
    public Ingredient maxCalories() {
        if (this.ingredients.isEmpty()) {
            return null;
        } else {
            // Hypothèse qu'un ingrédient apporte des calories >= 0
            Ingredient max = new Ingredient("FICTIF", 0.0, 0.0, 0.0, -1);
            // Parcours des ingrédients avec un "foreach"
            for (Ingredient i : this.ingredients.keySet()) {
                if (i.getCalories()>max.getCalories()) {
                    max = i;
                }
            }
            return max;
        }
    }

    /**
     * Retourne la liste des ingrédients dont l'apport en protéines
     * dépasse le seuil.
     * 
     * @param seuil : quantité de protéines à dépasser
     * @return : liste des ingrédients dépassant le seuil
     */
    public ArrayList<Ingredient> richeProteine(double seuil) {
        ArrayList<Ingredient> riches = new ArrayList<Ingredient>();
        for (Ingredient i : this.ingredients.keySet()) {
            if (i.getProteine()>seuil) {
                riches.add(i);
            }
        }
        return riches;
    }
}
