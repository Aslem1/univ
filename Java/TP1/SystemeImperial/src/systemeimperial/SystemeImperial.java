/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemeimperial;
import java.util.Scanner; //Importe la classe Scanner

/**
 *
 * @author aperrin
 */
public class SystemeImperial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in); //Créer un objet Scanner
        System.out.print("Saisissez un poids en kilogrammes : "); //Récupération entrée utilisateur
        double kg = input.nextDouble();
        double lbs = conversionKilogrammeVersLivre(kg);
        double oz = conversionKilogrammeVersOnce(kg);
        System.out.print(" Dans le système impérial, cela représente :"+ lbs +(" lbs ")+ ("et ") + oz +(" oz") ); //Output entrée utilisateur
    }
    
    public static double conversionKilogrammeVersLivre(double kilogramme){
        double lbs = kilogramme * 2.20462;
        return lbs;
    }
    
    public static double conversionKilogrammeVersOnce(double kilogramme){
        double oz = kilogramme * 35.2739199982575;
        return oz;
    }
}

