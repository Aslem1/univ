 #include "Vendeur.h"



Vendeur::Vendeur(string nom, string prenom, string adresse, int salaire, Employe* encadrant, int commission)
	:EmployeEncadre(nom, prenom, adresse, salaire, encadrant)
{
	this->m_commission = commission;
}

int Vendeur::donneRevenu()
{
	return this->m_salaire + this->m_commission;
}

