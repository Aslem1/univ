/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu;

import java.util.Scanner;

/**
 *
 * @author Jean-François
 */
public class Jeu {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        double hasard = Math.random(); // Nombre aléatoire entre 0 et 100.
        int surprise = (int) (100*hasard); // Conversion d'un double en entier.
        System.out.print("Saisissez un nombre entier entre 0 et 100 : ");
        Scanner sc = new Scanner(System.in);
        int nbUser = sc.nextInt();
        int essais=0;
        if (surprise>nbUser) {
            System.out.println("C'est plus !");
            essais ++;
        } 
        else if(surprise<nbUser) {
            System.out.println("C'est moins :-(");
            essais ++; 
        }
        else {
            System.out.println ("Félicitations tu as trouvé !");
        }
        while (surprise != nbUser);
    }
}