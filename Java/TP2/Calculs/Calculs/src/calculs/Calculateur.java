/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculs;
import java.util.Scanner; //Importe la classe Scanner
import java.util.ArrayList;

/**
 *
 * @author aperrin
 */
public class Calculateur {
    public void moyenne(){
        Scanner s = new Scanner(System.in);
        ArrayList<Double> notes = new ArrayList<>();
        for (double i = 0; i < 10; i++){
        System.out.println("Veuillez saisir une note: ");
        double str = s.nextDouble();
        notes.add(str);
       }
       System.out.println ("résultat: " + i/notes);
    }
}
