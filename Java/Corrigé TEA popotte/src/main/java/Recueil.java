
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agath
 */
class Recueil {
    private ArrayList<Plat> liste;

    public Recueil() {
        liste = new ArrayList<>();
    }

    public ArrayList<Plat> getCollection() {
        return liste;
    }
    
    public void ajoute(Plat t){
        liste.add(t);
    }
    
    public boolean contient(Plat p){
        for (Plat food:liste){
            if (food == p){
                return true;
            }
        }
        return false;
    }
    
    public long maxCalories(){
        if (liste.isEmpty()){
            return 0;
        }
        long max = 0;
        for (Plat food:liste){
            if (food.getCalories()>max){
                max = food.getCalories();
            }
        }
        return max;
    }
    
    public Plat platMaxCalories(){
        long max = 0;
        Plat res = null;
        for (Plat food:liste){
            if (food.getCalories()>max){
                max = food.getCalories();
                res = food;
            }
        }
        return res;
    }
    
    public int nbSupSeuil(long seuil){
        int compteur = 0;
        for (Plat food:liste){
           if (food.getCalories()>seuil){
               compteur++;
           }
        }
        return compteur;
    }
    
    public ArrayList<Plat> platSupSeuil(long seuil){
        ArrayList<Plat> platSup = new ArrayList<>();
        for (Plat food:liste){
           if (food.getCalories()>seuil){
               platSup.add(food);
           }
        }
        return platSup;
    }
    
    public Recueil fusionne(Recueil autre){
        Recueil fusion = new Recueil();
        for(Plat food:liste){
            if(autre.contient(food)){
                fusion.ajoute(food);
            }
        }
        return fusion;
    }
}
