#pragma once

#include <string.h>
#include <iostream>
using namespace std;

class Employe
{
public:
	Employe(string, string, string, int);
	string donneNom();
	int donneSalaire();
	virtual int donneRevenu();
	virtual Employe* donneEncadrant() = 0;
	void encadre(Employe*);
	Employe** donneSubordonnes(int*);
	enum 
	{ 
		maxEmpEncadres = 10 
	};

protected:
	string m_nom;
	string m_prenom;
	string m_adresse;
	int m_salaire;
	Employe** m_subordonnes;
	int m_nbSubordonnes;
};

