/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aslem.gestionhotel.entite;

import java.util.ArrayList;

/**
 *
 * @author agathe
 */
public class Client {
    // Champs de clients 
    public String name;
    int id;
    String adresse;
    
    // Liaison de clients
    ArrayList<HotelBooking> reservationHotel;
    ArrayList<PlaneTicket> reservationAvion;
    ArrayList<Stay> order;
    ArrayList<Stay> guest;
}
