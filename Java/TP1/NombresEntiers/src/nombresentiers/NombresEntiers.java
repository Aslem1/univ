/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nombresentiers;

import java.util.Scanner;

/**
 *
 * @author aperrin
 */
public class NombresEntiers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void afficherDiviseur(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez un nombre ");
        String str = sc.nextLine();
        System.out.println("Vous avez saisi : " + str);
    }
}
