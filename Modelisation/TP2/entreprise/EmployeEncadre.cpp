#include "EmployeEncadre.h"

EmployeEncadre::EmployeEncadre(string nom, string prenom, string adresse, int salaire, Employe* encadrant) 
	:Employe(nom, prenom, adresse, salaire)
{
	this->m_encadrant = encadrant;
	encadrant->encadre(this);
}

Employe* EmployeEncadre::donneEncadrant()
{
	return this->m_encadrant;
}

