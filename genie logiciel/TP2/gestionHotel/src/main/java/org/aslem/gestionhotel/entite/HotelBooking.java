/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aslem.gestionhotel.entite;

import java.util.Calendar;

/**
 *
 * @author agathe
 */
public class HotelBooking {
    //Champs
    int numRoom;
    Calendar start;
    Calendar end;
    int nbNight;
    String rec;
    boolean smoking;
    
    //Liaison
    Stay origin;
}
