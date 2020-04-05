import java.util.HashMap;

/**
 *
 * @author jviaud
 */
public class Panier {

    // -----------------------------------------------------------------------
    // CHAMP
    // -----------------------------------------------------------------------

    /**
     * Association des ingrédients et de la quantité en gramme présents
     * dans le panier.
     */
    private HashMap<Ingredient,Integer> inventaire;

    // -----------------------------------------------------------------------
    // CONSTRUCTEURS
    // -----------------------------------------------------------------------

    /**
     * Construit un panier vide.
     */
    public Panier() {
        this.inventaire = new HashMap<Ingredient,Integer>();
    }

    /**
     * Construit un panier à partir d'un inventaire existant.
     * 
     * @param inventaire : inventaire utilisé pour construire le panier.
     */
    public Panier(HashMap<Ingredient,Integer> inventaire) {
        this.inventaire = (HashMap<Ingredient,Integer>) inventaire.clone();
    }

    // -----------------------------------------------------------------------
    // GETTER
    // -----------------------------------------------------------------------

    /**
     * Retourne le contenu du panier.
     *
     * @return le contenu du panier
     */
    public HashMap<Ingredient, Integer> getContenu() {
        return this.inventaire;
    }

    /**
     * Retourne le poids total du panier.
     * 
     * @return poids du panier.
     */
    public double getPoids() {
        double poids = 0.0;
        for (Ingredient i : this.inventaire.keySet()) {
            poids += this.inventaire.get(i);
        }
        return poids;
    }

    /**
     * Teste la présence d'un ingrédient.
     * 
     * @param i ingrédient à rechercher
     * @return vrai si et seulement l'ingrédient est présent
     */
    public boolean estPresent(Ingredient i) {
        return this.inventaire.containsKey(i);
    }

    /**
     * Teste la présence d'un ingrédient.
     * 
     * @param i ingrédient à rechercher
     * @return vrai si et seulement l'ingrédient est présent
     */
    public boolean estPresentBis(Ingredient i) {
        return !(this.inventaire.get(i)==null);
    }

    // -----------------------------------------------------------------------
    // SETTER
    // -----------------------------------------------------------------------

    /**
     * Ajoute un ingrédient dans le panier.
     * Si l'ingrédient est déjà présent dans le plat, alors seule la quantité
     * est augmentée.
     *
     * @param i ingrédient à ajouter
     * @param qte quantité de l'ingrédient à ajouter
     */
    public void ajoute(Ingredient i, Integer qte) {
        if (this.inventaire.containsKey(i)) {
            this.inventaire.replace(i, this.inventaire.get(i) + qte);
        } else {
            this.inventaire.put(i, qte);
        }
    }

    /**
     * Retire une certaine quantité d'un ingrédient dans le panier.
     * Si l'ingrédient est déjà présent en quantité plus faible,
     * il est complètement retiré.
     *
     * @param i ingrédient à retirer
     * @param qte quantité de l'ingrédient à retirer
     */
    public void retire(Ingredient i, Integer qte) {
        if (this.inventaire.containsKey(i)) {
            // L'ingredient est présent dans le panier
            if (this.inventaire.get(i) <= qte) {
                // Il y a moins de quantité que ce qu'il faut retirer
                this.inventaire.remove(i);
            } else {
                // Il va rester de l'ingrédient dans le panier
                this.inventaire.replace(i, this.inventaire.get(i) - qte);
            }
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
        String s = "Panier{poids=" + this.getPoids() + "}\n";
        // Parcours des ingrédients avec un "foreach"
        for (Ingredient i : this.inventaire.keySet()) {
            s += '\t' + i.toString() + " -> quantité : " + 
                    this.inventaire.get(i) + '\n';
        }
        return s;
    }

    /**
     * Retoune vrai si et seulement si tous les ingrédients de P sont
     * en quantité suffisante dans le panier.
     * 
     * @param p : plat à tester
     * @return : vrai si les ingrédients de p sont en quantité suffisante
     */
    public boolean estCuisinable(Plat p) {
        boolean resultat = true;
        /* Les opérations disponibles avec les HashMap ne permettent pas
           l'implémentation d'une boucle while.
        */
        for (Ingredient i : p.getIngredients().keySet()) {
            if (this.inventaire.get(i) == null) {
                // L'ingrédient est absent
                resultat = false;
            } else {
                // L'ingrédient est présent
                if (p.getIngredients().get(i) > this.inventaire.get(i)) {
                    // La quantité présente dans le panier n'est pas suffisante
                    resultat = false;
                }
            /* Sinon l'ingrédient est présent en quantité suffisante
               resultat reste vrai
             */
            }
        }
        return resultat;
    }

    /**
     * Retourne un nouveau panier résultat de la fusion de p avec ce papier.
     * Les ingrédients des deux paniers sont présents une seule fois dans
     * le résultat où les quantités sont ajoutées.
     *
     * @param p panier à fusionner
     * @return résultat de la fusion de deux paniers.
     */
    public Panier fusionne(Panier p) {
        Panier fusion = new Panier(this.getContenu());
        
        // La méthode "ajoute" gère déjà les doublons
        for(Ingredient i : p.getContenu().keySet()) {
            fusion.ajoute(i, p.getContenu().get(i));
        }

        return fusion;
    }

    /**
     * Retourne un nouveau panier dans lequel les ingrédients du plat ont été
     * retirés.
     * Soit les quantités sont diminiées, soit l'ingrédient est complètement
     * enlevé. Il est supposé que le plat soit cuisinable.
     *
     * @param p : plat à préparer
     * @return  : panier avec les ingrédients du plat retirés
     */
    public Panier cuisine(Plat p) {
        Panier resultat = new Panier();
        
        for (Ingredient i : p.getIngredients().keySet()) {
            if (this.inventaire.get(i)!=null && 
                this.inventaire.get(i) > p.getIngredients().get(i)) {
                resultat.ajoute(i, this.inventaire.get(i) - 
                        p.getIngredients().get(i));
            }
        }
        return resultat;
    }

    /**
     * Retourne la liste des courses.
     *
     * Ingrédients manquant (ou insuffisant) pour préparer le plat.
     * @param p : plat à préparer
     * @return la liste des courses
     */
    public Panier achete(Plat p) {
        HashMap<Ingredient, Integer> liste = new HashMap<Ingredient, Integer>();
        for (Ingredient i : p.getIngredients().keySet()) {
            if (!this.inventaire.containsKey(i)) {
                // L'ingredient est absent
                liste.put(i, p.getIngredients().get(i));
            } else {
                if (this.inventaire.get(i) < p.getIngredients().get(i)) {
                    // Ingrédient présent en quantité insuffisante
                    // Achat de ce qu'il manque
                    liste.put(i, p.getIngredients().get(i) - 
                            this.inventaire.get(i));
                }
            } // Sinon, ingrédient déjà suffisamment présent; pas à acheter.
        }
        return new Panier(liste);
    }
}
