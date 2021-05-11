
#include "Entreprise.h"
#include "Directeur.h"
#include "Vendeur.h"
#include "Livreur.h"

#include <iostream>
#include <string>

using namespace std;

int main(int argc, char** argv)
{
    Directeur directeur("Durand", "Paul", "17000", 4000, 1000);
    Entreprise pme("MPE", "SARL", "17000", &directeur);
    Vendeur paul("Artaud", "Paul", "16000", 3000, &directeur, 1000);
    Vendeur pierre("Dupont", "Pierre", "16000", 2000, &paul, 500);
    Livreur marcel("Martin", "Marcel", "17200", 1500, &directeur);
    pme.recruter(&paul);
    pme.recruter(&pierre);
    pme.recruter(&marcel);

    int nbEmployes = 0;
    Employe** employes = pme.donneEmployes(&nbEmployes);
    cout << "nombre d'employes de l'entreprise = " << nbEmployes << endl;
    // on parcours l'ensemble des employes...
    for (int i = 0; i < nbEmployes; i++)
    {
        // on affiche leur salaire...
        cout << employes[i]->donneNom() << " a pour salaire " << employes[i]->donneSalaire();
        // on affiche leur salaire "total"
        cout << " et pour revenu " << employes[i]->donneRevenu();
        // on affiche leur encadrant
        Employe* encadrant = employes[i]->donneEncadrant();
        if (encadrant != 0)
            cout << " et a pour encadrant : " << encadrant->donneNom() << endl;
        else
            cout << endl;
        // on affiche les employes encadres
        int nbSubord = 0;
        Employe** subordonnes = employes[i]->donneSubordonnes(&nbSubord);
        if (subordonnes != 0)
        {
            cout << employes[i]->donneNom() << " encadre " << nbSubord << " personne(s) :" << endl;
            for (int s = 0; s < nbSubord; s++)
            {
                cout << "\t" + subordonnes[s]->donneNom() << endl;
            }
        }
    }
	cin.get();
    return 0;
}

