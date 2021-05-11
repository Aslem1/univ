#include "Entreprise.h"



Entreprise::Entreprise(string nom, string raisonSociale, string adresse, Directeur* dirigeant)
{
	this->m_nom = nom;
	this->m_raisonSociale = raisonSociale;
	this->m_adresse = adresse;
	this->m_dirigeant = dirigeant;
	this->m_nbEmployes = 1;
	this->m_employes[0] = dirigeant;
}

void Entreprise::recruter(Employe* recrue)
{
	if (this->m_nbEmployes < maxEmployes)
	{
		this->m_employes[this->m_nbEmployes] = recrue;
		this->m_nbEmployes++;
	}
}

Employe** Entreprise::donneEmployes(int* nb)
{
	*nb = this->m_nbEmployes;
	return (Employe**) this->m_employes;
}
