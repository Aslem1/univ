/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aslem.gestionhotel.entite;

import java.util.ArrayList;
import java.util.Calendar; //Pour utiliser la date


/**
 *
 * @author agathe
 */
public class Stay {
    //Champs
    Calendar start;
    Calendar end;
    
    //Liaisons
    ArrayList<PlaneTicket> transport;
    ArrayList<HotelBooking> reserved;
    
    //Méthode
    public double calculatePrice() {
        return 0.0;
    }
}
