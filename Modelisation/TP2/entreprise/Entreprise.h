#pragma once

#include <string.h>
#include <iostream>

#include "Directeur.h"

using namespace std;

class Entreprise
{
public:
	Entreprise(string, string, string, Directeur*);
	void recruter(Employe *);
	Employe** donneEmployes(int*);
	enum
	{
		maxEmployes = 10
	};
private:
	string m_nom;
	string m_adresse;
	string m_raisonSociale;
	int m_nbEmployes;
	Directeur* m_dirigeant;
	Employe* m_employes[maxEmployes];
};

