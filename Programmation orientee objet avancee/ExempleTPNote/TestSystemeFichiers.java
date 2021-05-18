package tp5;

import java.util.ArrayList;
import java.util.Collections;

public class TestSystemeFichiers
{

    public static void main(String[] args)
    {
        Repertoire racine = new Repertoire("racine");
        Repertoire rep1 = new Repertoire("rep1");
        Fichier f1 = new Fichier("f1", 100);
        Fichier f2 = new Fichier("f2", 150);

        racine.ajouteElt(rep1);
        rep1.ajouteElt(f2);
        racine.ajouteElt(f1);

        // test 1 : ajout d’un repertoire de meme nom
        Repertoire rep2 = new Repertoire("rep1");
        if (racine.ajouteElt(rep2))
            throw new Error("ajout d’un element de meme nom");

        // test 2 : ajout d’un fichier de meme nom
        System.out.println("Debut test...");
        Fichier f2bis = new Fichier("f2", 150);
        if (rep1.ajouteElt(f2bis))
            throw new Error("ajout d’un element de meme nom");

        // test 3 : suppression d’un element inexistant
        Repertoire rep3 = new Repertoire("rep3");
        if (racine.supprimeElt(rep3))
            throw new Error("suppression d’un element inexistant");

        // test 4 : liste des elements fils
        if (!rep1.ajouteElt(rep3))
            throw new Error("ajout element " + rep3 + " impossible");
        ArrayList<Noeud> fils = rep1.donneElementsFils();
        ArrayList<Noeud> resultatFils = new ArrayList<Noeud>();
        resultatFils.add(f2);
        resultatFils.add(rep3);
        if (!fils.equals(resultatFils))
            throw new Error("elements fils differents");

        /* A DECOMMENTER AU FUR ET A MESURE DE VOTRE PROGRESSION.... */
        // test 5 : calcul de la taille d’un repertoire
        if (racine.taille() != 250)
            throw new Error("calcul taille incorrect");

        // test 6 : recherche d’un element ayant le nom ’rep3’
        // et se situant a un niveau quelconque du systeme de fichiers
        ArrayList<Noeud> recherche = racine.rechercheElt("rep3");

        ArrayList<Noeud> resultatRecherche = new ArrayList<Noeud>();
        resultatRecherche.add(rep3);
        if (!recherche.equals(resultatRecherche))
            throw new Error("probleme sur le recherche d’un element");

        // creation d’un repertoire et d’un ficher de meme nom
        Repertoire testRep = new Repertoire("test");
        Fichier testFic = new Fichier("test", 75);
        if (!rep3.ajouteElt(testRep))
            throw new Error("ajout element " + testRep + " impossible");
        if (!rep1.ajouteElt(testFic))
            throw new Error("ajout element " + testFic + " impossible");

        // test 7 : recherche d’elements ayant le nom ’test’
        // et se situant a un niveau quelconque du systeme de fichiers
        recherche = racine.rechercheElt("test");
        resultatRecherche.clear();
        resultatRecherche.add(testFic);
        resultatRecherche.add(testRep);
        // pour eviter qu’il y ait des problemes d’ordre dans le resultat
        if (!recherche.containsAll(resultatRecherche) ||
                !resultatRecherche.containsAll(recherche))
            throw new Error("probleme sur le recherche d’un element");
        
        // test 8 : verification du parent
        if (racine.donneParent() != null)
            throw new Error("probleme sur la gestion du parent");
        if (rep3.donneParent() != rep1 || rep1.donneParent() != racine)
            throw new Error("probleme sur la gestion du parent");
        if (!racine.supprimeElt(f1))
            throw new Error("suppression impossible de " + f1);
        if (f1.donneParent() == racine)
            throw new Error("probleme sur la gestion du parent");

        // test 9 : verification du chemin absolu pour un fichier existant
        Fichier f3 = new Fichier("f3", 35);
        if (!rep3.ajouteElt(f3))
            throw new Error("ajout element " + f3 + " impossible");
        // maintenant le chemin absolu de f3 est : racine/rep1/rep3/f3
        ArrayList<Noeud> cheminF3absolu = racine.donneChemin(f3.donneId());
        ArrayList<Noeud> resultatCheminf3 = new ArrayList<Noeud>();
        // ajout des elements a la liste representant le ’bon’ resultat
        Collections.addAll(resultatCheminf3, racine, rep1, rep3, f3);
        if (!cheminF3absolu.equals(resultatCheminf3))
            throw new Error("chemin absolu de " + f3 + " incorrect");
        // test 10 : verification du chemin relatif pour un repertoire existant
        ArrayList<Noeud> cheminRep3absolu = rep1.donneChemin(rep3.donneId());
        ArrayList<Noeud> resultatCheminRep3 = new ArrayList<Noeud>();
        Collections.addAll(resultatCheminRep3, rep1, rep3);
        if (!cheminRep3absolu.equals(resultatCheminRep3))
            throw new Error("chemin relatif de " + rep3 + " incorrect");

        // test 11 : verification du chemin relatif pour un fichier existant
        ArrayList<Noeud> cheminF3relatif = rep3.donneChemin(f3.donneId());
        ArrayList<Noeud> resultatCheminF3relatif = new ArrayList<Noeud>();
        Collections.addAll(resultatCheminF3relatif, rep3, f3);
        if (!cheminF3relatif.equals(resultatCheminF3relatif))
            throw new Error("chemin relatif de " + f3 + " incorrect");

        // test 12 : verification du chemin relatif pour un fichier existant
        cheminF3relatif = f3.donneChemin(f3.donneId());
        resultatCheminF3relatif.remove(rep3);
        if (!cheminF3relatif.equals(resultatCheminF3relatif))
            throw new Error("chemin relatif de " + f3 + " incorrect");

        // test 13 : verification du chemin pour un fichier inaccessible
        ArrayList<Noeud> cheminVide = rep3.donneChemin(f2.donneId());
        if (!cheminVide.isEmpty())
            throw new Error("chemin de trouv’e pour un elt inaccessible");
        //*/

        System.out.println("Fin test.");
    }
}
