#include "Employe.h"

Employe::Employe(string nom, string prenom, string adresse, int salaire)
{
	this->m_nom = nom;
	this->m_prenom = prenom;
	this->m_adresse = adresse;
	this->m_salaire = salaire;
	this->m_nbSubordonnes = 0;
	this->m_subordonnes = new Employe*[maxEmpEncadres];
}

string Employe::donneNom()
{
	return this->m_nom;
}

int Employe::donneSalaire()
{
	return this->m_salaire;
}

int Employe::donneRevenu()
{
	return this->m_salaire;
}

void Employe::encadre(Employe* subordonne)
{
	if (this->m_nbSubordonnes < maxEmpEncadres)
	{
		this->m_subordonnes[this->m_nbSubordonnes] = subordonne;
		this->m_nbSubordonnes++;
	}
}

Employe** Employe::donneSubordonnes(int* nb)
{
	*nb = this->m_nbSubordonnes;
	return this->m_subordonnes;
}