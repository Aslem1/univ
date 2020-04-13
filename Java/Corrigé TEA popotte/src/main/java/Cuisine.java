
import java.util.HashMap;

/**
 *
 * @author jviaud
 */
public class Cuisine {
    public static void main(String[] args) {
        Recueil monRecueil = new Recueil();
        // -------------------------------------------------------------------
        // Classe Ingredient
        // -------------------------------------------------------------------
        
        // Test-Usage du constructeur d'Ingredient
        Ingredient carotte = new Ingredient("CAROTTE", 4.8, 0.98, 0.20, 26);

        // Test-Usage des getters d'Ingredient
        System.out.println(carotte.getNom() + " (glucide)" + 
                carotte.getGlucide());
        System.out.println(carotte.getNom() + " (proteine)" + 
                carotte.getProteine());
        System.out.println(carotte.getNom() + " (lipide)" + 
                carotte.getLipide());
        System.out.println(carotte.getNom() + " (kcal) : " + 
                carotte.getCalories());

        // Test-Usage du toString
        System.out.println(carotte.toString());
        System.out.println(carotte);

        // Test-Usage de equals
        Ingredient inconnu = carotte;
        String autre = "CAROTTE";
        Ingredient patate = new Ingredient("POMMEDETERRE", 18.0, 1.5, 0.1, 85);
        Ingredient oui = new Ingredient("CAROTTE",1, 2, 3, 4);
        System.out.println(carotte.equals(inconnu));
        System.out.println(carotte.equals(autre));
        System.out.println(carotte.equals(patate));
        System.out.println(carotte.equals(oui));
        System.out.println(carotte==oui);
        System.out.println(carotte==inconnu);
        
        // -------------------------------------------------------------------
        // Classe Plat
        // -------------------------------------------------------------------
        
        // Test-Usage du constructeur vide, de getNom et du toString
        Plat p = new Plat("PUREE");
        System.out.println(p.getNom());
        System.out.println(p);
        
        // Test-Usage de ajoute et du toString
        p.ajoute(carotte, 500);
        p.ajoute(patate, 500);
        System.out.println(p);
        
        // Test-Usage de getteurs
        System.out.println(p.getNom() + " (glucide) : " + p.getGlucide());
        System.out.println(p.getNom() + " (lipide) : " + p.getLipide());
        System.out.println(p.getNom() + " (proteine) : " + p.getProteine());
        System.out.println(p.getNom() + " (calories) : " + p.getCalories());
        
        // Test-Usage du constructeur avec ingrédients
        Plat pe = new Plat("PUREEPICEE",p.getIngredients());
        Ingredient piment = new Ingredient("POIVRON", 4.6, 0.9 , 0.2, 20);
        pe.ajoute(piment, 20);
        System.out.println(pe);
        
        // Test-Usage de maxCalories (A FINIR)
        System.out.println(p.maxCalories());
        System.out.println(pe.maxCalories());
        
        Plat vide = new Plat("VIDE");
        System.out.println(vide + "MAX : " + vide.maxCalories());
        
        Plat bis = new Plat("BIS",pe.getIngredients());
        bis.ajoute(new Ingredient("BIS", 1, 2, 3, 85), 50);
        System.out.println(bis + "MAX : " + bis.maxCalories());

        // Test-Usage de richeProteine (A FINIR)
        System.out.println(pe.richeProteine(6.0));
        System.out.println(pe.richeProteine(0.0));
        System.out.println(pe.richeProteine(1.0));

        // -------------------------------------------------------------------
        // Classe Panier
        // -------------------------------------------------------------------
        Panier paniervide = new Panier();
        System.out.println(paniervide);
        
        Panier petitpanier = new Panier(p.getIngredients());
        System.out.println(petitpanier);
        
        Panier grospanier = new Panier(petitpanier.getContenu());
        System.out.println(grospanier);

        // Inciter les étudiants à réfléchir sur les 4 tests ci-dessous.
        System.out.println(grospanier.estPresent(carotte));
        System.out.println(grospanier.estPresent(oui));
        System.out.println(grospanier.estPresentBis(carotte));
        System.out.println(grospanier.estPresentBis(oui));
        
        grospanier.ajoute(carotte, 100);
        petitpanier.retire(carotte, 100);
        System.out.println(grospanier);
        System.out.println(petitpanier);
        grospanier.ajoute(piment, 1000);
        petitpanier.retire(carotte, 1000);
        System.out.println(grospanier);
        System.out.println(petitpanier);
        petitpanier.retire(carotte, 1000);
        System.out.println(petitpanier);
        
        Panier grandsac = petitpanier.fusionne(grospanier);
        System.out.println(grandsac);
        
        System.out.println(petitpanier.estCuisinable(p));
        System.out.println(grandsac.estCuisinable(p));
        System.out.println(paniervide.estCuisinable(p));
        System.out.println(petitpanier.estCuisinable(vide));
        System.out.println(paniervide.estCuisinable(vide));

        System.out.println(petitpanier.cuisine(p));
        System.out.println(grandsac.cuisine(p));
        System.out.println(paniervide.cuisine(p));
        System.out.println(petitpanier.cuisine(vide));
        System.out.println(paniervide.cuisine(vide));
        
        System.out.println(petitpanier.achete(pe));
        System.out.println(grospanier.achete(p));
        System.out.println(paniervide.achete(p));
        System.out.println(paniervide.achete(vide));


        // -------------------------------------------------------------------
        // Exemple du cours
        // -------------------------------------------------------------------

        HashMap<String, Integer> demographie = new HashMap<>();
        demographie.put("AYTRE", 11135);
        demographie.put("LA JARNE", 3513);
        System.out.println(demographie);
        
        demographie.replace("LA JARNE", 3663);
        System.out.println(demographie);
        
        demographie.remove("LA JARNE");
        System.out.println(demographie);

        boolean faux = demographie.containsKey("LA JARNE");
        boolean vrai = demographie.containsKey("AYTRE");
        System.out.println(vrai);
        
        Integer nbAytresien = demographie.get("AYTRE");
        System.out.println(nbAytresien);
        
        Integer total = 0;
        for(String s : demographie.keySet()) {
            total += demographie.get(s); 
        }
        System.out.println(total);

    }
}
