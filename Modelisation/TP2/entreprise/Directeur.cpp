#include "Directeur.h"



Directeur::Directeur(string nom, string prenom, string adresse, int salaire, int prime):Employe(nom, prenom, adresse, salaire)
{
	this->m_prime = prime;
}

int Directeur::donneRevenu()
{
	return this->m_salaire + this->m_prime;
}

Employe* Directeur::donneEncadrant()
{
	return 0;
}
