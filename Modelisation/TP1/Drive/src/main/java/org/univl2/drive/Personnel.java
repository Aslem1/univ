package org.univl2.drive;

import java.util.List;

public class Personnel extends Personne {
	
	private List<Creneau> creneaux;

    public Personnel(String nom, String prenom) {
        super(nom, prenom);
    }
    
    public void ajouterCreneau (String jour, String heureDebut, String heurefin) {
    	
    }
    
    public void notifier (Commande commande) {
    	
    }
    
    
}
