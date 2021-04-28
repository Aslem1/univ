package org.aslem.bibliotheque;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe BiblioMM fournit un moyen de stocker des objets
 * CD et DVD. Une liste de tous les CD et DVD peut etre affichee
 * en mode texte.
 * 
 */
public class BiblioMM
{
    private ArrayList<EltMM> elementsMultimedias;

    /**
     * Construit une bibliotheque vide.
     */
    public BiblioMM()
    {
        this.elementsMultimedias = new ArrayList<EltMM>();
    }

    /**
     * Ajoute un element multimedia a la bibliotheque.
     * @param unElement Le EltMM a ajouter.
     */
    public void ajouterEltMM(EltMM unElement)
    {
        this.elementsMultimedias.add(unElement);
    }

    /**
     * Affiche une liste de tous les elements multimedias actuellement dans
     * la bibliotheque.
     */
    public void affiche()
    {
        for(EltMM elem : this.elementsMultimedias) {
            System.out.println(elem);   
        }
    }
    
    public List<EltMM> rechercherTitre(String unTitre) {
        List<EltMM> liste = new ArrayList<>();
        for(EltMM elem : this.elementsMultimedias) {
            if (unTitre.equals(elem.donneTitre())) {
                liste.add(elem);
            }
        }
        return liste;
    }
    
    public void emprunterTitre(String titre) {
        List<EltMM> listeEmprunt = rechercherTitre(titre);
        int nbEmprunt = listeEmprunt.size();
        if(nbEmprunt == 1 && listeEmprunt.get(0).donneEtatRayon()) {
            listeEmprunt.get(0).changeEtatRayon(false);
        }
    }
}
