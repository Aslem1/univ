#pragma once

#include <string.h>
#include <iostream>

#include "EmployeEncadre.h"

using namespace std;

class Vendeur: public EmployeEncadre
{
public:
	Vendeur(string, string, string, int, Employe*, int);
	virtual  int donneRevenu();
private:
	int m_commission;
};

