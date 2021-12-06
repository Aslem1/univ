package fabriqueMagasin;

import java.util.ArrayList;
import magasin.Animal;
import magasin.Bricolage;
import magasin.Jardinage;
import magasin.Produit;


public class SimpleFabrique {
    
    public Produit creerProduit(String ligne){
       //On initialise la variable produit à null
       
       //On crée un tableau vide qui va séparer les chaînes de caractère entre chaque ;
       
       String tableau[] = ligne.split(";");
       //on regarde dans le fichier texte 
       Produit p;
       if(tableau[0].equals("Jardinage")){
           p=new Jardinage(tableau[1],tableau[3],Double.parseDouble(tableau[2]),Integer.parseInt(tableau[4]),tableau[5]);
       }
        else if(tableau[0].equals("Animal")){
        p = new Animal(tableau[1],tableau[3],Double.parseDouble(tableau[2]),Integer.parseInt(tableau[4]),tableau[5],Double.parseDouble(tableau[6]));
        }
       else{
           p= new Bricolage(tableau[1],tableau[3],Double.parseDouble(tableau[2]),Integer.parseInt(tableau[4]),tableau[5],Boolean.parseBoolean(tableau[6]));
       }
       
      return p;
    }
   
}
