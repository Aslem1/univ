package org.univl2.drive;

import java.util.List;

public class Client extends Personne implements GestionCommande{
    private String dateInscription;
    
    
    //ajouterCommande

    // Constructeur
    public Client(String dateInscription, String nom, String prenom) {
        super(nom, prenom);
        this.dateInscription = dateInscription;
    }
    
    private List<Commande> commande;
}
